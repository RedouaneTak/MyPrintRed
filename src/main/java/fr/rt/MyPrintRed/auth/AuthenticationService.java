package fr.rt.MyPrintRed.auth;

import fr.rt.MyPrintRed.config.JwtService;
import fr.rt.MyPrintRed.entities.Role;
import fr.rt.MyPrintRed.entities.Utilisateur;
import fr.rt.MyPrintRed.repositories.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse registerUser(RegisterRequest request) {

        Optional<Utilisateur> userOptional = repository.findUserByEmail(request.getEmail());

        if(userOptional.isPresent())
            return AuthenticationResponse.builder().build();

        var user = Utilisateur.builder()
                .prenom(request.getPrenom())
                .nom(request.getNom())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(new Role(1,"USER"))
                .telephone(request.getTelephone())
                .build();
        repository.save(user);


        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public AuthenticationResponse registerAdmin(RegisterRequest request) {

        Optional<Utilisateur> userOptional = repository.findUserByEmail(request.getEmail());

        if(userOptional.isPresent())
            return AuthenticationResponse.builder().build();

        var user = Utilisateur.builder()
                .prenom(request.getPrenom())
                .nom(request.getNom())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(new Role(3,"ADMIN"))
                .telephone(request.getTelephone())
                .build();
        repository.save(user);


        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }



    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),request.getPassword()
                )
        );

        var user = repository.findUserByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


}
package fr.rt.MyPrintRed.services.impl;

import fr.rt.MyPrintRed.dto.UtilisateurDto;
import fr.rt.MyPrintRed.entities.Utilisateur;
import fr.rt.MyPrintRed.mapper.UtilisateurMapper;
import fr.rt.MyPrintRed.repositories.UtilisateurRepository;
import fr.rt.MyPrintRed.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    private final UtilisateurMapper utilisateurMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UtilisateurDto> getUtilisateurs() {
        return utilisateurMapper.toListDto(utilisateurRepository.findAll());
    }

    @Override
    public UtilisateurDto getUtilisateurById(Integer idUtilisateur) {

        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(idUtilisateur);

        return utilisateurMapper.toDto(utilisateur.orElseThrow());
    }

    @Override
    public void updateUtilisateur() {

    }
}

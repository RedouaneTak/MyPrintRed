package fr.rt.MyPrintRed.services.impl;

import fr.rt.MyPrintRed.dto.PasswordDto;
import fr.rt.MyPrintRed.dto.UtilisateurDto;
import fr.rt.MyPrintRed.dto.UtilisateurInfoDto;
import fr.rt.MyPrintRed.entities.Utilisateur;
import fr.rt.MyPrintRed.mapper.UtilisateurInfoMapper;
import fr.rt.MyPrintRed.mapper.UtilisateurMapper;
import fr.rt.MyPrintRed.repositories.UtilisateurRepository;
import fr.rt.MyPrintRed.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
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
    public UtilisateurDto updateUtilisateur(Integer idUtilisateur, UtilisateurInfoDto utilisateurDto) {

        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur).orElseThrow();

        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setTelephone(utilisateurDto.getTelephone());



        return utilisateurMapper.toDto(utilisateurRepository.save(utilisateur));

    }

    @Override
    public UtilisateurDto updateUtilisateurPassword(Integer idUtilisateur, PasswordDto passwordDto) {
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur).orElseThrow();

        utilisateur.setPassword(passwordEncoder.encode(passwordDto.getPassword()));



        return utilisateurMapper.toDto(utilisateurRepository.save(utilisateur));
    }


}

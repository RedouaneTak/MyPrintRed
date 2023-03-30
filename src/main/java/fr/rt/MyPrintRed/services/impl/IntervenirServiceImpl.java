package fr.rt.MyPrintRed.services.impl;

import fr.rt.MyPrintRed.dto.IntervenirDto;
import fr.rt.MyPrintRed.entities.Intervenir;
import fr.rt.MyPrintRed.entities.Utilisateur;
import fr.rt.MyPrintRed.mapper.IntervenirMapper;
import fr.rt.MyPrintRed.repositories.IntervenirRepository;
import fr.rt.MyPrintRed.repositories.UtilisateurRepository;
import fr.rt.MyPrintRed.services.IntervenirService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class IntervenirServiceImpl implements IntervenirService {

    private final IntervenirRepository repository;
    private final IntervenirMapper mapper;

    private final UtilisateurRepository utilisateurRepository;
    @Override
    public IntervenirDto insert(IntervenirDto intervenirDto) {

        Utilisateur utilisateur = utilisateurRepository.getReferenceById(intervenirDto.getIdUtilisateur());
        Intervenir intervenir = mapper.toEntity(intervenirDto);
        intervenir.getIntervenirPK().setUtilisateur(utilisateur);

        return mapper.toDto(repository.save(intervenir));
    }
}

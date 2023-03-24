package fr.rt.MyPrintRed.services.impl;

import fr.rt.MyPrintRed.dto.UtilisateurDto;
import fr.rt.MyPrintRed.mapper.UtilisateurMapper;
import fr.rt.MyPrintRed.repositories.UtilisateurRepository;
import fr.rt.MyPrintRed.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    private final UtilisateurMapper utilisateurMapper;

    @Override
    public List<UtilisateurDto> getUtilisateurs() {
        return utilisateurMapper.toListDto(utilisateurRepository.findAll());
    }
}

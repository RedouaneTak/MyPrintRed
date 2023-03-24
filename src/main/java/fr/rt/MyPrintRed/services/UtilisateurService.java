package fr.rt.MyPrintRed.services;

import fr.rt.MyPrintRed.dto.UtilisateurDto;
import fr.rt.MyPrintRed.dto.UtilisateurInfoDto;

import java.util.List;

public interface UtilisateurService {


    List<UtilisateurDto> getUtilisateurs();
    UtilisateurDto getUtilisateurById(Integer idUtilisateur);

    UtilisateurDto updateUtilisateur(Integer idUtilisateur, UtilisateurInfoDto utilisateurDto);
}

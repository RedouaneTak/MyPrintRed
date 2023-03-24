package fr.rt.MyPrintRed.services;

import fr.rt.MyPrintRed.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {


    List<UtilisateurDto> getUtilisateurs();
    UtilisateurDto getUtilisateurById(Integer idUtilisateur);

    void updateUtilisateur();
}

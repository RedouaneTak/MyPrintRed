package fr.rt.MyPrintRed.services;

import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.dto.AdresseUtilisateurDto;

import java.util.List;

public interface AdresseUtilisateurService {

    List<AdresseUtilisateurDto> getAll();

    List<AdresseUtilisateurDto> getAllById(Integer idUtilisateur);

    AdresseUtilisateurDto insert(Integer idUtilisateur , AdresseDto adresseDto);

    void deleteBy(Integer idUtilisateur,Integer idAdresse);



}

package fr.rt.MyPrintRed.mapper;

import fr.rt.MyPrintRed.dto.UtilisateurDto;
import fr.rt.MyPrintRed.dto.UtilisateurInfoDto;
import fr.rt.MyPrintRed.entities.Utilisateur;

public interface UtilisateurInfoMapper {

    UtilisateurInfoDto toDto(Utilisateur utilisateur);

    Utilisateur toUtilisateur(UtilisateurInfoDto utilisateurInfoDto);
}

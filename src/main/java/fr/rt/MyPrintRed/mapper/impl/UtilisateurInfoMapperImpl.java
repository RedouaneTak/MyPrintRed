package fr.rt.MyPrintRed.mapper.impl;

import fr.rt.MyPrintRed.dto.UtilisateurInfoDto;
import fr.rt.MyPrintRed.entities.Utilisateur;
import fr.rt.MyPrintRed.mapper.UtilisateurInfoMapper;

public class UtilisateurInfoMapperImpl implements UtilisateurInfoMapper {


    @Override
    public UtilisateurInfoDto toDto(Utilisateur utilisateur) {
        return new UtilisateurInfoDto(

                utilisateur.getNom(),
                utilisateur.getPrenom(),
                utilisateur.getEmail(),
                utilisateur.getTelephone()

        );
    }

    @Override
    public Utilisateur toUtilisateur(UtilisateurInfoDto utilisateurInfoDto) {
        return new Utilisateur(

                utilisateurInfoDto.getNom(),
                utilisateurInfoDto.getPrenom(),
                utilisateurInfoDto.getEmail(),
                utilisateurInfoDto.getTelephone()


        );
    }
}

package fr.rt.MyPrintRed.mapper.impl;

import fr.rt.MyPrintRed.dto.UtilisateurDto;
import fr.rt.MyPrintRed.entities.Utilisateur;
import fr.rt.MyPrintRed.mapper.UtilisateurMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Override
    public UtilisateurDto toDto(Utilisateur utilisateur) {
        return new UtilisateurDto(

                utilisateur.getNom(),
                utilisateur.getPrenom(),
                utilisateur.getEmail(),
                utilisateur.getTelephone()
        );
    }

    @Override
    public List<UtilisateurDto> toListDto(List<Utilisateur> utilisateurs) {
        List<UtilisateurDto> utilisateurDtos = new ArrayList<>();
        for(Utilisateur utilisateur : utilisateurs){
            utilisateurDtos.add(toDto(utilisateur));
        }

        return utilisateurDtos;
    }
}

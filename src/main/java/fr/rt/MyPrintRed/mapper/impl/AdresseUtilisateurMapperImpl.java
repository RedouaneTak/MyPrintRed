package fr.rt.MyPrintRed.mapper.impl;

import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.dto.AdresseUtilisateurDto;
import fr.rt.MyPrintRed.entities.AdresseUtilisateur;
import fr.rt.MyPrintRed.entities.AdresseUtilisateurPK;
import fr.rt.MyPrintRed.mapper.AdresseMapper;
import fr.rt.MyPrintRed.mapper.AdresseUtilisateurMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class AdresseUtilisateurMapperImpl implements AdresseUtilisateurMapper {

    private final AdresseMapper adresseMapper;

    @Override
    public AdresseUtilisateurDto toDto(AdresseUtilisateur adresseUtilisateur) {
        AdresseUtilisateurDto adresseUtilisateurDto = new AdresseUtilisateurDto();

        adresseUtilisateurDto.setIdUtilisateur(adresseUtilisateur.getAdresseUtilisateurPK().getIdUtilisateur());
        adresseUtilisateurDto.setAdresseDto(adresseMapper.toDto(adresseUtilisateur.getAdresseUtilisateurPK().getAdresse()));

        return adresseUtilisateurDto;
    }

    @Override
    public AdresseUtilisateur toEntity(AdresseUtilisateurDto adresseUtilisateurDto) {

       AdresseUtilisateur adresseUtilisateur = new AdresseUtilisateur();

       adresseUtilisateur.setAdresseUtilisateurPK(new AdresseUtilisateurPK(
               adresseUtilisateurDto.getIdUtilisateur(),
               adresseMapper.toAdresse(adresseUtilisateurDto.getAdresseDto())
               ));
        return adresseUtilisateur;
    }

    @Override
    public AdresseUtilisateur fromIdAndAdresseDto(Integer idUtilisateur, AdresseDto adresseDto) {

        AdresseUtilisateur adresseUtilisateur = new AdresseUtilisateur();

        adresseUtilisateur.setAdresseUtilisateurPK(new AdresseUtilisateurPK(idUtilisateur,adresseMapper.toAdresse(adresseDto)));

        return adresseUtilisateur;
    }


    @Override
    public List<AdresseUtilisateurDto> toListDto(List<AdresseUtilisateur> adresseUtilisateurs) {

        List<AdresseUtilisateurDto> dtoList = new ArrayList<>();
        for(AdresseUtilisateur adressU : adresseUtilisateurs){
            dtoList.add(toDto(adressU));
        }

        return dtoList;
    }
}

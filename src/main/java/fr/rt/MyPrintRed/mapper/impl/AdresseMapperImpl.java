package fr.rt.MyPrintRed.mapper.impl;


import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.dto.UtilisateurDto;
import fr.rt.MyPrintRed.entities.Adresse;
import fr.rt.MyPrintRed.entities.Utilisateur;
import fr.rt.MyPrintRed.mapper.AdresseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AdresseMapperImpl implements AdresseMapper {
    @Override
    public AdresseDto toDto(Adresse adresse) {
        return new AdresseDto(
                adresse.getIdAdresse(),
                adresse.getRue(),
                adresse.getComplement(),
                adresse.getCodePostal(),
                adresse.getVille()

        );
    }

    @Override
    public Adresse toAdresse(AdresseDto adresseDto) {
        return new Adresse(
                adresseDto.getIdAdresse(),
                adresseDto.getRue(),
                adresseDto.getComplement(),
                adresseDto.getCodePostal(),
                adresseDto.getVille()

        );
    }

    @Override
    public List<AdresseDto> toListDto(List<Adresse> adresses) {
        List<AdresseDto> adresseDtos = new ArrayList<>();
        for(Adresse adresse : adresses){
            adresseDtos.add(toDto(adresse));
        }

        return adresseDtos;
    }
}

package fr.rt.MyPrintRed.mapper;


import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.dto.AdresseUtilisateurDto;

import fr.rt.MyPrintRed.entities.AdresseUtilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,uses = {AdresseMapper.class})
public interface AdresseUtilisateurMapper {

    AdresseUtilisateurDto toDto(AdresseUtilisateur adresseUtilisateur);

    AdresseUtilisateur toEntity(AdresseUtilisateurDto adresseUtilisateurDto);

    AdresseUtilisateur fromIdAndAdresseDto(Integer idUtilisateur, AdresseDto adresseDto);


    List<AdresseUtilisateurDto> toListDto(List<AdresseUtilisateur> adresseUtilisateurs);
}

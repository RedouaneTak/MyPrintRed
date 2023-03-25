package fr.rt.MyPrintRed.mapper;

import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.entities.Adresse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;


@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AdresseMapper {

    AdresseDto toDto(Adresse adresse);

    Adresse toAdresse(AdresseDto adresseDto);


    List<AdresseDto> toListDto(List<Adresse> adresses);


}

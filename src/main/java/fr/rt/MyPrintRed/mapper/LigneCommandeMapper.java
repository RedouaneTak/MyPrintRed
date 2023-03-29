package fr.rt.MyPrintRed.mapper;


import fr.rt.MyPrintRed.dto.LigneCommandeDto;
import fr.rt.MyPrintRed.entities.LigneCommande;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {StatusMapper.class})
public interface LigneCommandeMapper {

    LigneCommandeDto toDto(LigneCommande ligneCommande);

    LigneCommande toEntity(LigneCommandeDto ligneCommandeDto);

    List<LigneCommandeDto> toDtoList(List<LigneCommande> ligneCommandes);
}

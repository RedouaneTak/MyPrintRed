package fr.rt.MyPrintRed.mapper;

import fr.rt.MyPrintRed.dto.TypeOptionDto;
import fr.rt.MyPrintRed.entities.TypeOption;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TypeOptionMapper {


    TypeOptionDto toDto(TypeOption typeOption);

    TypeOption toEntity(TypeOptionDto typeOptionDto);
}

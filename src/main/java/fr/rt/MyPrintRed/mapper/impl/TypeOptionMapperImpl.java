package fr.rt.MyPrintRed.mapper.impl;

import fr.rt.MyPrintRed.dto.TypeOptionDto;
import fr.rt.MyPrintRed.entities.TypeOption;
import fr.rt.MyPrintRed.mapper.TypeOptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeOptionMapperImpl implements TypeOptionMapper {
    @Override
    public TypeOptionDto toDto(TypeOption typeOption) {
        return new TypeOptionDto(
                typeOption.getIdTypeOption(),
                typeOption.getLibelle()
        );
    }

    @Override
    public TypeOption toEntity(TypeOptionDto typeOptionDto) {
        return new TypeOption(
                typeOptionDto.idTypeOption,
                typeOptionDto.getLibelle()
        );
    }
}

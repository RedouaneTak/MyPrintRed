package fr.rt.MyPrintRed.mapper.impl;

import fr.rt.MyPrintRed.dto.TypeOptionDto;
import fr.rt.MyPrintRed.entities.TypeOption;
import fr.rt.MyPrintRed.mapper.TypeOptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<TypeOptionDto> toDtoList(List<TypeOption> typeOptions) {
        List<TypeOptionDto> dtoList = new ArrayList<>();
        typeOptions.stream().forEach(typeOption -> dtoList.add(toDto(typeOption)));
        return dtoList;
    }
}

package fr.rt.MyPrintRed.services;


import fr.rt.MyPrintRed.dto.TypeOptionDto;
import fr.rt.MyPrintRed.entities.TypeOption;

import java.util.List;

public interface TypeOptionService {

    List<TypeOptionDto> getTypeOptions();

    TypeOptionDto getById(Integer idTypeOption);

    TypeOptionDto insert(TypeOptionDto typeOptionDto);

    TypeOptionDto update(Integer idTypeOption,TypeOptionDto typeOptionDto);

    void deleteById(Integer idTypeOption);


}

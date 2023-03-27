package fr.rt.MyPrintRed.services.impl;

import fr.rt.MyPrintRed.dto.TypeOptionDto;
import fr.rt.MyPrintRed.entities.TypeOption;
import fr.rt.MyPrintRed.mapper.TypeOptionMapper;
import fr.rt.MyPrintRed.repositories.TypeOptionRepository;
import fr.rt.MyPrintRed.services.TypeOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TypeOptionServiceImpl implements TypeOptionService {

    private final TypeOptionRepository repository;

    private final TypeOptionMapper mapper;


    @Override
    public List<TypeOptionDto> getTypeOptions() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public TypeOptionDto getById(Integer idTypeOption) {
        return mapper.toDto(repository.findById(idTypeOption).orElseThrow());
    }

    @Override
    public TypeOptionDto insert(TypeOptionDto typeOptionDto) {
        return mapper.toDto(repository.save(mapper.toEntity(typeOptionDto)));
    }

    @Override
    public TypeOptionDto update(Integer idTypeOption, TypeOptionDto typeOptionDto) {

        repository.findById(idTypeOption).orElseThrow();
        typeOptionDto.setIdTypeOption(idTypeOption);
        TypeOption typeOption = mapper.toEntity(typeOptionDto);
        return mapper.toDto(repository.save(typeOption));

    }

    @Override
    public void deleteById(Integer idTypeOption) {
        repository.findById(idTypeOption).orElseThrow();
        repository.deleteById(idTypeOption);

    }
}

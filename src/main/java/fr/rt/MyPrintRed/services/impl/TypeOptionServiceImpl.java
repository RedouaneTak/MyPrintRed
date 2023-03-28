package fr.rt.MyPrintRed.services.impl;


import fr.rt.MyPrintRed.dto.TypeOptionDto;
import fr.rt.MyPrintRed.entities.TypeOptionPK;
import fr.rt.MyPrintRed.mapper.TypeOptionMapper;
import fr.rt.MyPrintRed.repositories.TypeOptionRepository;
import fr.rt.MyPrintRed.services.TypeOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public TypeOptionDto getById(Integer idOption,Integer idTypeOption) {
        return mapper.toDto(repository.findById(new TypeOptionPK(idOption,idTypeOption)).orElseThrow());
    }

    @Override
    public TypeOptionDto insert(TypeOptionDto typeOptionDto) {
        Optional<Integer> index = repository.getMaxId(typeOptionDto.getIdOption());
        
        if(index.isPresent())
            typeOptionDto.setIdTypeOption(index.get()+1);
        else
            typeOptionDto.setIdTypeOption(1);

        return mapper.toDto(repository.save(mapper.toEntity(typeOptionDto)));

    }


}

package fr.rt.MyPrintRed.services.impl;

import fr.rt.MyPrintRed.dto.OptionCategorieDto;
import fr.rt.MyPrintRed.dto.TypeOptionDto;
import fr.rt.MyPrintRed.mapper.OptionCategorieMapper;
import fr.rt.MyPrintRed.repositories.OptionCategorieRepository;
import fr.rt.MyPrintRed.services.OptionCategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class OptionCategorieServiceImpl implements OptionCategorieService {


    private final OptionCategorieRepository repository;
    private final OptionCategorieMapper mapper;

    @Override
    public List<OptionCategorieDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public List<OptionCategorieDto> getAllByIdCategorie(Integer idCategorie) {
        return mapper.toDtoList(repository.getAllByIdCategorie(idCategorie));
    }

    @Override
    public OptionCategorieDto insert(OptionCategorieDto optionCategorieDto) {
        return mapper.toDto(repository.save(mapper.toEntity(optionCategorieDto)));
    }

    @Override
    public void removeTypeOptionsFromCategorie(OptionCategorieDto optionCategorieDto){



        repository.delete(mapper.toEntity(optionCategorieDto));

    }


}

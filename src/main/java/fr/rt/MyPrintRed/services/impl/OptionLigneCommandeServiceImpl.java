package fr.rt.MyPrintRed.services.impl;

import fr.rt.MyPrintRed.dto.OptionLigneCommandeDto;
import fr.rt.MyPrintRed.mapper.OptionLigneCommandeMapper;
import fr.rt.MyPrintRed.repositories.OptionLigneCommandeRepository;
import fr.rt.MyPrintRed.services.OptionLigneCommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OptionLigneCommandeServiceImpl implements OptionLigneCommandeService {

    private final OptionLigneCommandeRepository repository;
    private final OptionLigneCommandeMapper mapper;

    @Override
    public List<OptionLigneCommandeDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public List<OptionLigneCommandeDto> getAllByNumeros(Integer numeroCommande, Integer numeroLigneCommande) {
        return mapper.toDtoList(repository.getAllByNumeros(numeroCommande,numeroLigneCommande));
    }

    @Override
    public OptionLigneCommandeDto insert(OptionLigneCommandeDto optionLigneCommandeDto) {
        return mapper.toDto(repository.save(mapper.toEntity(optionLigneCommandeDto)));
    }

    @Override
    public void delete(OptionLigneCommandeDto optionLigneCommandeDto) {

        repository.findById(mapper.toEntity(optionLigneCommandeDto).getOptionLigneCommandePK()).orElseThrow();
        repository.delete(mapper.toEntity(optionLigneCommandeDto));
    }
}

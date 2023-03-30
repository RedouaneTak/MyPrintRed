package fr.rt.MyPrintRed.services.impl;


import fr.rt.MyPrintRed.dto.InsertLigneCommandeDto;
import fr.rt.MyPrintRed.dto.LigneCommandeDto;
import fr.rt.MyPrintRed.entities.LigneCommande;
import fr.rt.MyPrintRed.entities.LigneCommandePK;
import fr.rt.MyPrintRed.mapper.LigneCommandeMapper;
import fr.rt.MyPrintRed.repositories.LigneCommandeRepository;
import fr.rt.MyPrintRed.services.LigneCommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LigneCommandeServiceImpl implements LigneCommandeService {

    private final LigneCommandeRepository repository;

    private final LigneCommandeMapper mapper;

    @Override
    public List<LigneCommandeDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public List<LigneCommandeDto> getAllByNumeroCommande(Integer numeroCommande) {
        return mapper.toDtoList(repository.getAllByNumeroCommande(numeroCommande));
    }

    @Override
    public LigneCommandeDto getAllByNumeros(Integer numeroCommande, Integer numeroLigneCommande) {
        return mapper.toDto(repository.findById(new LigneCommandePK(numeroCommande,numeroLigneCommande)).orElseThrow());
    }

    @Override
    public LigneCommandeDto insert(InsertLigneCommandeDto insertDto) {

        Optional<Integer> index = repository.getMaxId(insertDto.getNumeroCommande());
        System.out.println("INDEX = " + index);
        LigneCommande ligneCommande = mapper.toEntity(insertDto);

        if(index.isPresent())
            ligneCommande.getLigneCommandePK().setNumeroLigneCommande(index.get() + 1);
        else
            ligneCommande.getLigneCommandePK().setNumeroLigneCommande(1);

        System.out.println("LC = " + ligneCommande);

        return mapper.toDto(repository.save(ligneCommande));
        
    }
}
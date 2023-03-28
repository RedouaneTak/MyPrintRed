package fr.rt.MyPrintRed.services.impl;


import fr.rt.MyPrintRed.dto.CommandeDto;
import fr.rt.MyPrintRed.dto.InsertCommandeDto;
import fr.rt.MyPrintRed.entities.Commande;
import fr.rt.MyPrintRed.mapper.CommandeMapper;
import fr.rt.MyPrintRed.repositories.CommandeRepository;
import fr.rt.MyPrintRed.services.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;
    private final CommandeMapper commandeMapper;

    @Override
    public List<CommandeDto> getCommandes() {
        return commandeMapper.toDtoList(commandeRepository.findAll());
    }

    @Override
    public CommandeDto getById(Integer numeroCommande) {
        return commandeMapper.toDto(commandeRepository.findById(numeroCommande).orElseThrow());
    }

    @Override
    public CommandeDto insert(InsertCommandeDto insertCommandeDto) {

        Optional<Integer> index = commandeRepository.getMaxId();
        Commande commande = commandeMapper.toEntity(insertCommandeDto);

        if(index.isPresent())
            commande.setNumeroCommande(index.get()+1);
        else
            commande.setNumeroCommande(1);

        System.out.println(commande);
        return commandeMapper.toDto(commandeRepository.save(commande));

    }
}

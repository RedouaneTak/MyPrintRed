package fr.rt.MyPrintRed.services;

import fr.rt.MyPrintRed.dto.CommandeDto;

import java.util.List;

public interface CommandeService {

    List<CommandeDto> getCommandes();

    CommandeDto getById(Integer numeroCommande);

    CommandeDto insert(CommandeDto commandeDto);
}

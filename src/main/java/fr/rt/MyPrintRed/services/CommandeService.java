package fr.rt.MyPrintRed.services;

import fr.rt.MyPrintRed.dto.CommandeDto;
import fr.rt.MyPrintRed.dto.InsertCommandeDto;

import java.util.List;

public interface CommandeService {

    List<CommandeDto> getCommandes();

    CommandeDto getById(Integer numeroCommande);

    CommandeDto insert(InsertCommandeDto insertCommandeDto);

    CommandeDto updateStatus(Integer numeroCommande,Integer idStatus);

}

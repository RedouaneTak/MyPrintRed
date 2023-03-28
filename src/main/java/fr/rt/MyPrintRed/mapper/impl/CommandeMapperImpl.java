package fr.rt.MyPrintRed.mapper.impl;

import fr.rt.MyPrintRed.dto.CommandeDto;
import fr.rt.MyPrintRed.entities.Commande;
import fr.rt.MyPrintRed.mapper.AdresseMapper;
import fr.rt.MyPrintRed.mapper.CommandeMapper;
import fr.rt.MyPrintRed.mapper.StatusMapper;
import fr.rt.MyPrintRed.mapper.UtilisateurMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandeMapperImpl implements CommandeMapper {

    private final StatusMapper statusMapper;
    private final UtilisateurMapper utilisateurMapper;
    private final AdresseMapper adresseMapper;

    @Override
    public CommandeDto toDto(Commande commande) {
        return new CommandeDto(
                commande.getNumeroCommande(),
                commande.getPrixCommande(),
                commande.getDate(),
                statusMapper.toDto(commande.getStatus()),
                utilisateurMapper.toDto(commande.getUtilisateur()),
                adresseMapper.toDto(commande.getAdresse())
        );
    }

    @Override
    public Commande toEntity(CommandeDto commandeDto) {
        return new Commande(
                commandeDto.getNumeroCommande(),
                commandeDto.getPrixCommande(),
                commandeDto.getDate(),
                statusMapper.toEntity(commandeDto.getStatusDto()),
                utilisateurMapper.toUtilisateur(commandeDto.getUtilisateurDto()),
                adresseMapper.toAdresse(commandeDto.getAdresseDto())
        );
    }

    @Override
    public List<CommandeDto> toDtoList(List<Commande> commandes) {
        List<CommandeDto> dtoList = new ArrayList<>();
        commandes.stream().forEach(commande -> dtoList.add(toDto(commande)));
        return  dtoList;
    }
}

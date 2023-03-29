package fr.rt.MyPrintRed.mapper.impl;


import fr.rt.MyPrintRed.dto.LigneCommandeDto;
import fr.rt.MyPrintRed.entities.LigneCommande;
import fr.rt.MyPrintRed.entities.LigneCommandePK;
import fr.rt.MyPrintRed.mapper.LigneCommandeMapper;
import fr.rt.MyPrintRed.mapper.StatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LigneCommandeMapperImpl implements LigneCommandeMapper {

    private final StatusMapper statusMapper;


    @Override
    public LigneCommandeDto toDto(LigneCommande ligneCommande) {
        return new LigneCommandeDto(
                ligneCommande.getLigneCommandePK().getNumeroCommande(),
                ligneCommande.getLigneCommandePK().getNumeroLigneCommande(),
                ligneCommande.isRectoVerso(),
                ligneCommande.isCouleur(),
                ligneCommande.getNombreExemplaire(),
                ligneCommande.getNombreFeuille(),
                ligneCommande.getFichier(),
                ligneCommande.getPrixLigneCommande(),
                statusMapper.toDto(ligneCommande.getStatus())
        );
    }

    @Override
    public LigneCommande toEntity(LigneCommandeDto ligneCommandeDto) {
        return new LigneCommande(
                new LigneCommandePK(ligneCommandeDto.getNumeroCommande(), ligneCommandeDto.getNumeroLigneCommande()),
                ligneCommandeDto.getRectoVerso(),
                ligneCommandeDto.getCouleur(),
                ligneCommandeDto.getNombreExemplaire(),
                ligneCommandeDto.getNombreFeuille(),
                ligneCommandeDto.getFichier(),
                ligneCommandeDto.getPrixLigneCommande(),
                statusMapper.toEntity(ligneCommandeDto.getStatusDto())
        );
    }

    @Override
    public List<LigneCommandeDto> toDtoList(List<LigneCommande> ligneCommandes) {
        List<LigneCommandeDto> dtoList = new ArrayList<>();
        ligneCommandes.stream().forEach(ligneCommande -> dtoList.add(toDto(ligneCommande)));
        return dtoList;
    }
}

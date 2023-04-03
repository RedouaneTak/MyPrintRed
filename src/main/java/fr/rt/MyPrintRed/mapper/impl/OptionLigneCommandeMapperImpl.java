package fr.rt.MyPrintRed.mapper.impl;

import fr.rt.MyPrintRed.dto.OptionLigneCommandeDto;
import fr.rt.MyPrintRed.entities.OptionLigneCommande;
import fr.rt.MyPrintRed.entities.OptionLigneCommandePK;
import fr.rt.MyPrintRed.mapper.OptionLigneCommandeMapper;
import fr.rt.MyPrintRed.mapper.TypeOptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OptionLigneCommandeMapperImpl implements OptionLigneCommandeMapper {

    private final TypeOptionMapper typeOptionMapper;


    @Override
    public OptionLigneCommandeDto toDto(OptionLigneCommande entity) {
        return new OptionLigneCommandeDto(
                entity.getOptionLigneCommandePK().getNumeroCommande(),
                entity.getOptionLigneCommandePK().getNumeroLigneCommande(),
                typeOptionMapper.toDto(entity.getOptionLigneCommandePK().getTypeOption())
        );
    }

    @Override
    public OptionLigneCommande toEntity(OptionLigneCommandeDto dto) {
        return new OptionLigneCommande(
               new OptionLigneCommandePK(
                       dto.getNumeroCommande(),
                       dto.getNumeroLigneCommande(),
                       typeOptionMapper.toEntity(dto.getTypeOptionDto())
               )
        );
    }

    @Override
    public List<OptionLigneCommandeDto> toDtoList(List<OptionLigneCommande> optionLigneCommandes) {
        List<OptionLigneCommandeDto> dtoList = new ArrayList<>();
        optionLigneCommandes.stream().forEach(optionLigneCommande -> dtoList.add(toDto(optionLigneCommande)));
        return dtoList;
    }
}

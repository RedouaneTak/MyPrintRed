package fr.rt.MyPrintRed.mapper.impl;

import fr.rt.MyPrintRed.dto.CategorieDto;
import fr.rt.MyPrintRed.entities.Categorie;
import fr.rt.MyPrintRed.mapper.CategorieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategorieMapperImpl implements CategorieMapper {
    @Override
    public CategorieDto toDto(Categorie categorie) {
        return new CategorieDto(
                categorie.getIdCategorie(),
                categorie.getNom()
        );
    }

    @Override
    public Categorie toEntity(CategorieDto categorieDto) {
        return new Categorie(
                categorieDto.getIdCategorie(),
                categorieDto.getNom()
        );
    }
}

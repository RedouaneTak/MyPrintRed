package fr.rt.MyPrintRed.services;

import fr.rt.MyPrintRed.dto.CategorieDto;

public interface CategorieService {

    CategorieDto insert(CategorieDto categorieDto);

    CategorieDto update(Integer idCategorie,CategorieDto categorieDto);

    CategorieDto getById(Integer idCategorie);
}

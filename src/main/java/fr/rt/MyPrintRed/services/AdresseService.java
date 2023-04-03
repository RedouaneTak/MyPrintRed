package fr.rt.MyPrintRed.services;

import fr.rt.MyPrintRed.dto.AdresseDto;

import java.util.List;

public interface AdresseService {

    AdresseDto insertAdresse(AdresseDto adresseDto);


    List<AdresseDto> getAdresses();

    AdresseDto getAdresseById(Integer idAdresse);

    AdresseDto updateAdresse(Integer idAdresse,AdresseDto adresseDto);

    void deleteById(Integer idAdresse);
}

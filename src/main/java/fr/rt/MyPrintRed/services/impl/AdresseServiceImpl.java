package fr.rt.MyPrintRed.services.impl;


import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.entities.Adresse;
import fr.rt.MyPrintRed.mapper.AdresseMapper;
import fr.rt.MyPrintRed.repositories.AdresseRepository;
import fr.rt.MyPrintRed.services.AdresseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;
    private final AdresseMapper adresseMapper;

    @Override
    public AdresseDto insertAdresse(AdresseDto adresseDto) {
       return adresseMapper.toDto(adresseRepository.save(adresseMapper.toAdresse(adresseDto)));
    }

    @Override
    public List<AdresseDto> getAdresses() {
        return adresseMapper.toListDto(adresseRepository.findAll());
    }

    @Override
    public AdresseDto getAdresseById(Integer idAdresse) {
        return adresseMapper.toDto(adresseRepository.findById(idAdresse).orElseThrow());
    }

    @Override
    public AdresseDto updateAdresse(Integer idAdresse, AdresseDto adresseDto) {

        Adresse adresseOptional =  adresseRepository.findById(idAdresse).orElseThrow();
        adresseDto.setIdAdresse(idAdresse);

        Adresse adresse = adresseMapper.toAdresse(adresseDto);



        return adresseMapper.toDto(adresseRepository.save(adresse));
    }

    @Override
    public void deleteById(Integer idAdresse) {

        adresseRepository.findById(idAdresse).orElseThrow();

        adresseRepository.deleteById(idAdresse);

    }
}

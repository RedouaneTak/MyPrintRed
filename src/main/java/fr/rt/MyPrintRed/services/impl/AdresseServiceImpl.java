package fr.rt.MyPrintRed.services.impl;


import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.mapper.AdresseMapper;
import fr.rt.MyPrintRed.repositories.AdresseRepository;
import fr.rt.MyPrintRed.services.AdresseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}

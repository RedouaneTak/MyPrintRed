package fr.rt.MyPrintRed.services.impl;

import fr.rt.MyPrintRed.dto.AdresseDto;
import fr.rt.MyPrintRed.dto.AdresseUtilisateurDto;
import fr.rt.MyPrintRed.entities.Adresse;
import fr.rt.MyPrintRed.entities.AdresseUtilisateur;
import fr.rt.MyPrintRed.mapper.AdresseMapper;
import fr.rt.MyPrintRed.mapper.AdresseUtilisateurMapper;
import fr.rt.MyPrintRed.repositories.AdresseUtilisateurRepository;
import fr.rt.MyPrintRed.services.AdresseService;
import fr.rt.MyPrintRed.services.AdresseUtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class AdresseUtilisateurServiceImpl implements AdresseUtilisateurService {

    private final AdresseUtilisateurRepository repository;

    private final AdresseService adresseService;
    private final AdresseUtilisateurMapper mapper;

    private final AdresseMapper adresseMapper;

    @Override
    public List<AdresseUtilisateurDto> getAll() {
        return mapper.toListDto(repository.findAll());
    }

    @Override
    public AdresseUtilisateurDto insert(Integer idUtilisateur , AdresseDto adresseDto) {

        AdresseDto  adresseDtoAdded =adresseService.insertAdresse(adresseDto);

        return mapper.toDto(repository.save(mapper.fromIdAndAdresseDto(idUtilisateur,adresseDtoAdded)));
    }

    @Override
    public void deleteBy(Integer idUtilisateur, Integer idAdresse) {
        Adresse adresse = new Adresse();
        adresse.setIdAdresse(idAdresse);

        repository.deleteByAdresseUtilisateurPK_IdUtilisateurAndAdresseUtilisateurPK_Adresse(idUtilisateur, adresse);

        adresseService.deleteById(idAdresse);

    }


}

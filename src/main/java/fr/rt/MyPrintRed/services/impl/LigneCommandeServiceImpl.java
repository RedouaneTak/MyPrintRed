package fr.rt.MyPrintRed.services.impl;


import fr.rt.MyPrintRed.mapper.LigneCommandeMapper;
import fr.rt.MyPrintRed.repositories.LigneCommandeRepository;
import fr.rt.MyPrintRed.services.LigneCommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LigneCommandeServiceImpl implements LigneCommandeService {

    private final LigneCommandeRepository repository;
    private final LigneCommandeMapper mapper;
}

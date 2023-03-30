package fr.rt.MyPrintRed.mapper.impl;

import fr.rt.MyPrintRed.dto.IntervenirDto;
import fr.rt.MyPrintRed.entities.Intervenir;
import fr.rt.MyPrintRed.entities.IntervenirPK;
import fr.rt.MyPrintRed.entities.Utilisateur;
import fr.rt.MyPrintRed.mapper.IntervenirMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IntervenirMapperImpl implements IntervenirMapper {


    @Override
    public IntervenirDto toDto(Intervenir intervenir) {
        return new IntervenirDto(
                intervenir.getIntervenirPK().getNumeroCommande(),
                intervenir.getIntervenirPK().getNumeroLigneCommande(),
                intervenir.getIntervenirPK().getUtilisateur().getIdUtilisateur(),
                intervenir.getIntervenirPK().getUtilisateur().getNom(),
                intervenir.getIntervenirPK().getUtilisateur().getNom()
        );
    }

    @Override
    public Intervenir toEntity(IntervenirDto intervenirDto) {
        return new Intervenir(
                new IntervenirPK(intervenirDto.getNumeroCommande(), intervenirDto.getNumeroLigneCommande(),
                        new Utilisateur(intervenirDto.getIdUtilisateur()))
        );
    }
}

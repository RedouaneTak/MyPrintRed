package fr.rt.MyPrintRed.mapper;

import fr.rt.MyPrintRed.dto.IntervenirDto;
import fr.rt.MyPrintRed.entities.Intervenir;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IntervenirMapper {

    @Mapping(source = "intervenirPK.utilisateur.idUtilisateur",target = "idUtilisateur")
    @Mapping(source = "intervenirPK.utilisateur.nom",target = "nom")
    @Mapping(source = "intervenirPK.utilisateur.prenom",target = "prenom")
    @Mapping(source = "intervenirPK.numeroCommande",target = "numeroCommande")
    @Mapping(source = "intervenirPK.numeroLigneCommande",target = "numeroLigneCommande")
    IntervenirDto toDto(Intervenir intervenir);


    @Mapping(source = "idUtilisateur",target = "intervenirPK.utilisateur.idUtilisateur")
    @Mapping(source = "numeroCommande",target = "intervenirPK.numeroCommande")
    @Mapping(source = "numeroLigneCommande",target = "intervenirPK.numeroLigneCommande")
    Intervenir toEntity(IntervenirDto intervenirDto);
}

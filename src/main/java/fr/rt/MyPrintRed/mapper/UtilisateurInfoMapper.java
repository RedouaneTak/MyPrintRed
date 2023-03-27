package fr.rt.MyPrintRed.mapper;


import fr.rt.MyPrintRed.dto.UtilisateurInfoDto;
import fr.rt.MyPrintRed.entities.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UtilisateurInfoMapper {

    UtilisateurInfoDto toDto(Utilisateur utilisateur);

    Utilisateur toUtilisateur(UtilisateurInfoDto utilisateurInfoDto);
}

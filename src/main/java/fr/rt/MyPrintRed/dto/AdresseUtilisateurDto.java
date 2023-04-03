package fr.rt.MyPrintRed.dto;


import fr.rt.MyPrintRed.entities.AdresseUtilisateurPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdresseUtilisateurDto extends HateOas {

    private Integer idUtilisateur;

    private AdresseDto adresseDto;

}

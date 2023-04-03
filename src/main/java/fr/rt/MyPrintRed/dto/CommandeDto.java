package fr.rt.MyPrintRed.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDto extends HateOas{

    private Integer numeroCommande;
    private BigDecimal prixCommande;
    private Date date;
    private StatusDto statusDto;
    private UtilisateurDto utilisateurDto;
    private AdresseDto adresseDto;
}

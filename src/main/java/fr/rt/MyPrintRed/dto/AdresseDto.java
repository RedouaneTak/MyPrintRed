package fr.rt.MyPrintRed.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdresseDto {

    private Integer idAdresse;
    private String rue;
    private String complement;
    private String codePostal;
    private String ville;
}

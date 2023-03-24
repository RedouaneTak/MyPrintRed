package fr.rt.MyPrintRed.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adresse_utilisateur", schema = "public", catalog = "MYPRINTRED")
public class AdresseUtilisateur {

    @EmbeddedId
    private AdresseUtilisateurPK adresseUtilisateurPK;


}

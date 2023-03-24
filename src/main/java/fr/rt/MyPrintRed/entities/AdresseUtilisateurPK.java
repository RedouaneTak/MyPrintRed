package fr.rt.MyPrintRed.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AdresseUtilisateurPK implements Serializable {

    @Column(name = "id_utilisateur")
    private int idUtilisateur;

    @ManyToOne
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

}

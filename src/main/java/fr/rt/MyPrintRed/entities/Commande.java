package fr.rt.MyPrintRed.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commande", schema = "public", catalog = "MYPRINTRED")
public class Commande {


    @Id
    @Column(name = "numero_commande")
    private int numeroCommande;

    @Basic
    @Column(name = "prix_commande")
    private BigDecimal prixCommande;

    @Basic
    @Column(name = "date")
    private Date date;


    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;


}

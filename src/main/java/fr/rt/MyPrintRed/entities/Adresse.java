package fr.rt.MyPrintRed.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adresse", schema = "public", catalog = "MYPRINTRED")
public class Adresse {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_adresse")
    private int idAdresse;
    @Basic
    @Column(name = "rue")
    private String rue;
    @Basic
    @Column(name = "complement")
    private String complement;
    @Basic
    @Column(name = "code_postal")
    private String codePostal;
    @Basic
    @Column(name = "ville")
    private String ville;


    public Adresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }
}

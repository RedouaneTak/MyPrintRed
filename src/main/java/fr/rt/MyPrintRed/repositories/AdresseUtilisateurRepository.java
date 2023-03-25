package fr.rt.MyPrintRed.repositories;


import fr.rt.MyPrintRed.entities.Adresse;
import fr.rt.MyPrintRed.entities.AdresseUtilisateur;
import fr.rt.MyPrintRed.entities.AdresseUtilisateurPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseUtilisateurRepository extends JpaRepository<AdresseUtilisateur, AdresseUtilisateurPK> {

    void deleteByAdresseUtilisateurPK_IdUtilisateurAndAdresseUtilisateurPK_Adresse(Integer id, Adresse adresse);

    List<AdresseUtilisateur> findAdresseUtilisateursByAdresseUtilisateurPK_IdUtilisateur(Integer id);

}

package fr.rt.MyPrintRed.repositories;

import fr.rt.MyPrintRed.entities.AdresseUtilisateur;
import fr.rt.MyPrintRed.entities.AdresseUtilisateurPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseUtilisateurRepository extends JpaRepository<AdresseUtilisateur, AdresseUtilisateurPK> {

}

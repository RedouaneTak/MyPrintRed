package fr.rt.MyPrintRed.repositories;


import fr.rt.MyPrintRed.entities.LigneCommande;
import fr.rt.MyPrintRed.entities.LigneCommandePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandePK> {
}

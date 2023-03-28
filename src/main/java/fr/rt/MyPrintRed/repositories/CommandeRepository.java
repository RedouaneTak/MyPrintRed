package fr.rt.MyPrintRed.repositories;

import fr.rt.MyPrintRed.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Integer> {

    @Query(value = "SELECT max(c.numeroCommande) from Commande c")
    Optional<Integer> getMaxId();
}

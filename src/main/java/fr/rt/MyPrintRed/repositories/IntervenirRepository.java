package fr.rt.MyPrintRed.repositories;

import fr.rt.MyPrintRed.entities.Intervenir;
import fr.rt.MyPrintRed.entities.IntervenirPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervenirRepository extends JpaRepository<Intervenir, IntervenirPK> {
}

package fr.rt.MyPrintRed.repositories;

import fr.rt.MyPrintRed.entities.TypeOption;
import fr.rt.MyPrintRed.entities.TypeOptionPK;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeOptionRepository extends JpaRepository<TypeOption, TypeOptionPK> {


    //select max(id_type_option) from type_option where id_option = 1
    @Query(value = "SELECT max(to.typeOptionPK.idTypeOption) from TypeOption to where to.typeOptionPK.idOption = :#{#idOption}")
    Optional<Integer> getMaxId(@Param("idOption") Integer idOption);
}

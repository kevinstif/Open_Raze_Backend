package pe.edu.upc.raze.users.professions.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.raze.users.professions.domain.model.entity.ProfessionModel;

@Repository
public interface ProfessionRepository extends JpaRepository <ProfessionModel, Long> {
}

package pe.edu.upc.raze.consultancies.top.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.raze.consultancies.top.domain.model.entity.TopModel;

public interface TopRepository extends JpaRepository <TopModel, Long> {
}

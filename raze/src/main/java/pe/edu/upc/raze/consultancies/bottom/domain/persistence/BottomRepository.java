package pe.edu.upc.raze.consultancies.bottom.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.raze.consultancies.bottom.domain.model.entity.BottomModel;

public interface BottomRepository extends JpaRepository <BottomModel, Long> {
}

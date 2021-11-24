package pe.edu.upc.raze.consultancies.footwear.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.raze.consultancies.footwear.domain.model.entity.FootwearModel;

public interface FootwearRepository  extends JpaRepository <FootwearModel, Long> {
}

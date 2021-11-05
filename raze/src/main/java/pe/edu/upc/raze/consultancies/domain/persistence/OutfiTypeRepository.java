package pe.edu.upc.raze.consultancies.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.raze.consultancies.domain.model.entity.OutfiType;

@Repository
public interface OutfiTypeRepository extends JpaRepository<OutfiType,Long> {
}

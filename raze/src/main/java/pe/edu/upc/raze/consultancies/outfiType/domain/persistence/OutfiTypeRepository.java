package pe.edu.upc.raze.consultancies.outfiType.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.raze.consultancies.outfiType.domain.model.entity.OutfiType;

@Repository
public interface OutfiTypeRepository extends JpaRepository<OutfiType,Long> {
}

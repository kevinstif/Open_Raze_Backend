package pe.edu.upc.raze.posts.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.raze.posts.domain.model.entity.Fashion;

@Repository
public interface FashionRepository extends JpaRepository<Fashion, Long> {

}

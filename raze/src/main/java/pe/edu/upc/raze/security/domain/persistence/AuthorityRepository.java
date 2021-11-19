package pe.edu.upc.raze.security.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.raze.security.domain.model.entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}

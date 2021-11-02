package pe.edu.upc.raze.users.interests.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.raze.users.interests.domain.model.entity.Interest;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
}

package pe.edu.upc.raze.users.customers.userAdvised.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.raze.users.customers.userAdvised.domain.model.entity.UserAdvised;

public interface UserAdvisedRepository extends JpaRepository<UserAdvised,Long> {
}

package pe.edu.upc.raze.users.customers.userAdvisors.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.raze.users.customers.userAdvisors.domain.model.entity.UserAdvisor;

public interface UserAdvisorRepository extends JpaRepository<UserAdvisor,Long> {
}
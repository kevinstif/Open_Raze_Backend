package pe.edu.upc.raze.security.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.raze.security.domain.model.entity.Role;
import pe.edu.upc.raze.security.domain.model.enumeration.Roles;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Roles name);

    boolean existsByName(Roles name);

}

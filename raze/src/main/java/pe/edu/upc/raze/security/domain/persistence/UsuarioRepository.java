package pe.edu.upc.raze.security.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.raze.security.domain.model.entity.User;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
}

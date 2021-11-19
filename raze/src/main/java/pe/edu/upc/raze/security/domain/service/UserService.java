package pe.edu.upc.raze.security.domain.service;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import pe.edu.upc.raze.security.domain.model.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    ResponseEntity<?> authenticate(AuthenticateRequest request);
    ResponseEntity<?> register(RegisterRequest request);
    List<User> getAll();
    User getById(Long userId);
    User update(Long userId, User request);
    ResponseEntity<?> delete(Long userId);
}

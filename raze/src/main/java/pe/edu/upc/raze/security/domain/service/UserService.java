package pe.edu.upc.raze.security.domain.service;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.security.domain.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long userId);

    User register(User request, Long interestId, Long professionId);

    // ResponseEntity<?> authenticate(AuthenticateRequest request);
    User update(Long userId, User request);

    ResponseEntity<?> delete(Long userId);
}

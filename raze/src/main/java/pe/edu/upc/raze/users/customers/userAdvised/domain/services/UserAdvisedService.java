package pe.edu.upc.raze.users.customers.userAdvised.domain.services;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.users.customers.userAdvised.domain.model.entity.UserAdvised;
import java.util.List;

public interface UserAdvisedService {
    List<UserAdvised> GetAll();
    UserAdvised GetById(Long UserAdvisedId);
    UserAdvised Create(UserAdvised userAdvised);
    UserAdvised Update(Long UserAdvisedId,UserAdvised request);
    ResponseEntity<?> Delete(Long UserAdvisedId);
}

package pe.edu.upc.raze.users.customers.userAdvisors.domain.services;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.users.customers.userAdvisors.domain.model.entity.UserAdvisor;

import java.util.List;

public interface UserAdvisorService {
    List<UserAdvisor> GetAll();
    UserAdvisor GetById(Long UserAdvisorId);
    UserAdvisor Create(UserAdvisor userAdvisor);
    UserAdvisor Update(Long UserAdvisorId,UserAdvisor request);
    ResponseEntity<?> Delete(Long UserAdvisorId);
}

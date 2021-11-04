package pe.edu.upc.raze.users.professions.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.users.professions.domain.model.entity.ProfessionModel;

import java.util.List;

public interface ProfessionService {
    List<ProfessionModel> getAll();
    Page<ProfessionModel> getAll(Pageable pageable);
    ProfessionModel getById(Long professionId);
    ProfessionModel create(ProfessionModel profession);
    ProfessionModel update(Long professionId, ProfessionModel request);
    ResponseEntity<?> delete(Long professionId);
}

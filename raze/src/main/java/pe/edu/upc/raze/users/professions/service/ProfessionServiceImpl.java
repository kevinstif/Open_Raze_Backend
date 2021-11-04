package pe.edu.upc.raze.users.professions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;
import pe.edu.upc.raze.users.professions.domain.model.entity.ProfessionModel;
import pe.edu.upc.raze.users.professions.domain.persistence.ProfessionRepository;
import pe.edu.upc.raze.users.professions.domain.service.ProfessionService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    private static final String ENTITY = "Profession";

    private final ProfessionRepository professionRepository;

    private final Validator validator;

    public ProfessionServiceImpl(ProfessionRepository professionRepository, Validator validator) {
        this.professionRepository = professionRepository;
        this.validator = validator;
    }

    public List<ProfessionModel> getAll() {
        return professionRepository.findAll();
    }

    @Override
    public Page<ProfessionModel> getAll(Pageable pageable) {
        return professionRepository.findAll(pageable);
    }

    @Override
    public ProfessionModel getById(Long professionId) {
        return professionRepository.findById(professionId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, professionId));
    }

    @Override
    public ProfessionModel create(ProfessionModel request) {
        Set<ConstraintViolation<ProfessionModel>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return professionRepository.save(request);

    }

    @Override
    public ProfessionModel update(Long professionId, ProfessionModel request) {

        Set<ConstraintViolation<ProfessionModel>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return professionRepository.findById(professionId).map(profession ->
            professionRepository.save(
                    profession.withName(request.getName())
                               .withDescription(request.getDescription()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, professionId));
    }

    @Override
    public ResponseEntity<?> delete(Long professionId) {
        return professionRepository.findById(professionId).map(profession -> {
            professionRepository.delete(profession);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, professionId));
    }
}

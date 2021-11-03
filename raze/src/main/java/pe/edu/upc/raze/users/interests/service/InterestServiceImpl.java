package pe.edu.upc.raze.users.interests.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.users.interests.domain.model.entity.Interest;
import pe.edu.upc.raze.users.interests.domain.persistence.InterestRepository;
import pe.edu.upc.raze.users.interests.domain.service.InterestService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class InterestServiceImpl implements InterestService {

    private static final String ENTITY = "Interest";
    private final InterestRepository interestRepository;
    private final Validator validator;

    public InterestServiceImpl(InterestRepository interestRepository, Validator validator) {
        this.interestRepository = interestRepository;
        this.validator = validator;
    }

    @Override
    public List<Interest> getAll() {
        return interestRepository.findAll();
    }

    @Override
    public Interest getById(Long interestId) {
        return interestRepository.findById(interestId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, interestId));
    }

    @Override
    public Interest create(Interest interest) {
        Set<ConstraintViolation<Interest>> violations = validator.validate(interest);
        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }
        return interestRepository.save(interest);
    }

    @Override
    public Interest update(Long interestId, Interest request) {
        Set<ConstraintViolation<Interest>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return interestRepository.findById(interestId).map(interest -> {
                interestRepository.save(interest.withTitle(request.getTitle()));
                return interestRepository.save(interest.withDescription(request.getDescription()));
    }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, interestId));
    }

    @Override
    public ResponseEntity<?> delete(Long interestId) {
        return interestRepository.findById(interestId).map(interest -> {
            interestRepository.delete(interest);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, interestId));
    }
}

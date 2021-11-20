package pe.edu.upc.raze.posts.fashions.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.posts.fashions.domain.model.entity.Fashion;
import pe.edu.upc.raze.posts.fashions.domain.persistence.FashionRepository;
import pe.edu.upc.raze.posts.fashions.domain.service.FashionService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class FashionServiceImpl implements FashionService {

    private static final String ENTITY = "Fashion";
    private final FashionRepository fashionRepository;
    private final Validator validator;

    public FashionServiceImpl(FashionRepository fashionRepository, Validator validator) {
        this.fashionRepository = fashionRepository;
        this.validator = validator;
    }

    @Override
    public List<Fashion> getAll() {
        return fashionRepository.findAll();
    }

    @Override
    public Fashion getById(Long fashionId) {
        return fashionRepository.findById(fashionId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, fashionId));
    }

    @Override
    public Fashion create(Fashion fashion) {
        Set<ConstraintViolation<Fashion>> violations = validator.validate(fashion);
        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }
        return fashionRepository.save(fashion);
    }

    @Override
    public Fashion update(Long fashionId, Fashion request) {
        Set<ConstraintViolation<Fashion>> violations = validator.validate(request);
        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }
        return fashionRepository.findById(fashionId).map(fashion ->
                fashionRepository.save(
                        fashion.withTitle(request.getTitle())
                )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, fashionId));
    }

    @Override
    public ResponseEntity<?> delete(Long fashionId) {
        return fashionRepository.findById(fashionId).map(fashion -> {
            fashionRepository.delete(fashion);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, fashionId));
    }
}

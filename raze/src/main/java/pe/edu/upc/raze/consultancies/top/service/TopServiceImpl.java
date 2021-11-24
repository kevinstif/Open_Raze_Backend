package pe.edu.upc.raze.consultancies.top.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.consultancies.top.domain.model.entity.TopModel;
import pe.edu.upc.raze.consultancies.top.domain.persistence.TopRepository;
import pe.edu.upc.raze.consultancies.top.domain.service.TopService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class TopServiceImpl implements TopService {
    private static final String ENTITY ="Top";

    private final TopRepository topRepository;
    private final Validator validator;

    public TopServiceImpl(TopRepository topRepository, Validator validator){
        this.topRepository = topRepository;
        this.validator = validator;
    }

    @Override
    public List<TopModel> getAll() {
        return topRepository.findAll();
    }

    @Override
    public Page<TopModel> getAll(Pageable pageable) {
        return topRepository.findAll(pageable);
    }

    @Override
    public TopModel getById(Long topId) {
        return topRepository.findById(topId)
                .orElseThrow( ()-> new ResourceNotFoundException(ENTITY, topId));
    }

    @Override
    public TopModel create(TopModel top) {
        Set<ConstraintViolation<TopModel>> violations = validator.validate(top);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return topRepository.save(top) ;
    }

    @Override
    public TopModel update(Long topId, TopModel request) {
        Set<ConstraintViolation<TopModel>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return   topRepository.findById(topId).map( footwear -> topRepository.save(
                footwear.withName(request.getName())
                        .withImage(request.getImage()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, topId) );
    }

    @Override
    public ResponseEntity<?> delete(Long topId) {
        return topRepository.findById(topId).map(footwear -> {
            topRepository.delete(footwear);
            return ResponseEntity.ok().build();
        } ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, topId));
    }
}

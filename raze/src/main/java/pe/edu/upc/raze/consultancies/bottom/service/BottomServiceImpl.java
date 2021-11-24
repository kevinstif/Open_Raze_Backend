package pe.edu.upc.raze.consultancies.bottom.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.consultancies.bottom.domain.model.entity.BottomModel;
import pe.edu.upc.raze.consultancies.bottom.domain.persistence.BottomRepository;
import pe.edu.upc.raze.consultancies.bottom.domain.service.BottomService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class BottomServiceImpl implements BottomService {
    private static final String ENTITY ="Bottom";

    private final BottomRepository bottomRepository;
    private final Validator validator;

    public BottomServiceImpl(BottomRepository bottomRepository, Validator validator){
        this.bottomRepository = bottomRepository;
        this.validator = validator;
    }

    @Override
    public List<BottomModel> getAll() {
        return bottomRepository.findAll();
    }

    @Override
    public Page<BottomModel> getAll(Pageable pageable) {
        return bottomRepository.findAll(pageable);
    }

    @Override
    public BottomModel getById(Long bottomId) {
        return bottomRepository.findById(bottomId)
                .orElseThrow( ()-> new ResourceNotFoundException(ENTITY, bottomId));
    }

    @Override
    public BottomModel create(BottomModel bottom) {
        Set<ConstraintViolation<BottomModel>> violations = validator.validate(bottom);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return bottomRepository.save(bottom) ;
    }

    @Override
    public BottomModel update(Long bottomId, BottomModel request) {
        Set<ConstraintViolation<BottomModel>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return   bottomRepository.findById(bottomId).map( footwear -> bottomRepository.save(
                footwear.withName(request.getName())
                        .withImage(request.getImage()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, bottomId) );
    }

    @Override
    public ResponseEntity<?> delete(Long bottomId) {
        return bottomRepository.findById(bottomId).map(footwear -> {
            bottomRepository.delete(footwear);
            return ResponseEntity.ok().build();
        } ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, bottomId));
    }
}

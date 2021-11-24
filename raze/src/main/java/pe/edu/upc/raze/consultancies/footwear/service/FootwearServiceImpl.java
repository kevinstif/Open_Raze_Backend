package pe.edu.upc.raze.consultancies.footwear.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.consultancies.footwear.domain.model.entity.FootwearModel;
import pe.edu.upc.raze.consultancies.footwear.domain.persistence.FootwearRepository;
import pe.edu.upc.raze.consultancies.footwear.domain.service.FootwearService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class FootwearServiceImpl implements FootwearService {

    private static final String ENTITY ="Footwear";

    private final FootwearRepository footwearRepository;
    private final Validator validator;

    public FootwearServiceImpl(FootwearRepository footwearRepository, Validator validator){
        this.footwearRepository = footwearRepository;
        this.validator = validator;
    }

    @Override
    public List<FootwearModel> getAll( ) {
        return footwearRepository.findAll();
    }

    @Override
    public Page<FootwearModel> getAll(Pageable pageable) {

        return footwearRepository.findAll(pageable);
    }

    @Override
    public FootwearModel getById(Long footwearId) {
        return footwearRepository.findById(footwearId)
                .orElseThrow( ()-> new ResourceNotFoundException(ENTITY, footwearId));
    }

    @Override
    public FootwearModel create(FootwearModel footwear) {
        Set<ConstraintViolation<FootwearModel>> violations = validator.validate(footwear);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return footwearRepository.save(footwear) ;
    }

    @Override
    public FootwearModel update(Long footwearId, FootwearModel request) {
        Set<ConstraintViolation<FootwearModel>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return   footwearRepository.findById(footwearId).map( footwear -> footwearRepository.save(
                footwear.withName(request.getName())
                        .withImage(request.getImage()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, footwearId) );
    }

    @Override
    public ResponseEntity<?> delete(Long footwearId) {
        return footwearRepository.findById(footwearId).map(footwear -> {
            footwearRepository.delete(footwear);
            return ResponseEntity.ok().build();
        } ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, footwearId));
    }
}

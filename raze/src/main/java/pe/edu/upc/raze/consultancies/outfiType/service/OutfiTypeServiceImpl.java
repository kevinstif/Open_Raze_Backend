package pe.edu.upc.raze.consultancies.outfiType.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.consultancies.outfiType.domain.model.entity.OutfiType;
import pe.edu.upc.raze.consultancies.outfiType.domain.persistence.OutfiTypeRepository;
import pe.edu.upc.raze.consultancies.outfiType.domain.services.OutfiTypeService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class OutfiTypeServiceImpl implements OutfiTypeService {

    private static final String ENTITY="OutfiType";
    private final OutfiTypeRepository outfiTypeRepository;
    private final Validator validator;

    public OutfiTypeServiceImpl(OutfiTypeRepository outfiTypeRepository, Validator validator){
        this.outfiTypeRepository=outfiTypeRepository;
        this.validator=validator;
    }

    @Override
    public List<OutfiType> GetAll() {
        return outfiTypeRepository.findAll();
    }

    @Override
    public OutfiType GetById(Long OutfiTypeId) {
        return outfiTypeRepository.findById(OutfiTypeId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,OutfiTypeId));
    }

    @Override
    public OutfiType Create(OutfiType request) {

        Set<ConstraintViolation<OutfiType>> violations= validator.validate(request);

         if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        return outfiTypeRepository.save(request);
    }

    @Override
    public OutfiType Update(Long OutfiTypeId, OutfiType request) {

        Set<ConstraintViolation<OutfiType>> violations= validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        return outfiTypeRepository.findById(OutfiTypeId)
                .map(outfiType->outfiTypeRepository.save(
                        outfiType.withName(request.getName())
                                .withDescription(request.getDescription())
                                .withUrl(request.getUrl())
                )).orElseThrow(()->new ResourceNotFoundException(ENTITY,OutfiTypeId));
    }

    @Override
    public ResponseEntity<?> Delete(Long OutfiTypeId) {

        return outfiTypeRepository.findById(OutfiTypeId)
                .map(outfiType -> {
                    outfiTypeRepository.delete(outfiType);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,OutfiTypeId));
    }
}

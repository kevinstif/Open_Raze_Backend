package pe.edu.upc.raze.consultancies.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.consultancies.domain.model.entity.OutfitType;
import pe.edu.upc.raze.consultancies.domain.persistence.OutfitTypeRepository;
import pe.edu.upc.raze.consultancies.domain.services.OutfitTypeService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class OutfitTypeServiceImpl implements OutfitTypeService {

    private static final String ENTITY="OutfitType";
    private final OutfitTypeRepository outfitTypeRepository;
    private final Validator validator;

    public  OutfitTypeServiceImpl(OutfitTypeRepository outfitTypeRepository,Validator validator){
        this.outfitTypeRepository=outfitTypeRepository;
        this.validator=validator;
    }

    @Override
    public List<OutfitType> GetAll() {
        return outfitTypeRepository.findAll();
    }

    @Override
    public OutfitType GetById(Long OutfitTypeId) {
        return outfitTypeRepository.findById(OutfitTypeId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,OutfitTypeId));
    }

    @Override
    public OutfitType Create(OutfitType request) {

        Set<ConstraintViolation<OutfitType>> violations= validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        return outfitTypeRepository.save(request);
    }

    @Override
    public OutfitType Update(Long OutfitTypeId, OutfitType request) {

        Set<ConstraintViolation<OutfitType>> violations= validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        var outfitTypeUpdate=outfitTypeRepository.findById(OutfitTypeId)
                .map(outfitType->outfitTypeRepository.save(
                        outfitType.withName(request.getName())
                                .withDescription(request.getDescription())
                                .withUrl(request.getUrl())
                )).orElseThrow(()->new ResourceNotFoundException(ENTITY,OutfitTypeId));

        return outfitTypeUpdate;
    }

    @Override
    public ResponseEntity<?> Delete(Long OutfitTypeId) {

        return outfitTypeRepository.findById(OutfitTypeId)
                .map(outfitType -> {
                    outfitTypeRepository.delete(outfitType);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,OutfitTypeId));
    }
}

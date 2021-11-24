package pe.edu.upc.raze.consultancies.outfits.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.consultancies.outfits.domain.model.entity.Outfit;
import pe.edu.upc.raze.consultancies.outfits.domain.persistence.OutfitRepository;
import pe.edu.upc.raze.consultancies.outfits.domain.services.OutfitService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class OutfitServiceImpl implements OutfitService {

    private static final String ENTITY="Outfit";
    private final OutfitRepository outfitRepository;
    private final Validator validator;

    public  OutfitServiceImpl(OutfitRepository outfitRepository,Validator validator){
        this.outfitRepository=outfitRepository;
        this.validator=validator;
    }

    @Override
    public List<Outfit> GetAll() {
        return outfitRepository.findAll();
    }

    @Override
    public Outfit GetById(Long OutfitId) {
        return outfitRepository.findById(OutfitId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,OutfitId));
    }

    @Override
    public Outfit Create(Outfit request) {

        Set<ConstraintViolation<Outfit>> violations= validator.validate(request);

         if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        return outfitRepository.save(request);
    }

    @Override
    public Outfit Update(Long OutfitId, Outfit request) {

        Set<ConstraintViolation<Outfit>> violations= validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        return outfitRepository.findById(OutfitId)
                .map(outfit->outfitRepository.save(
                        outfit.withName(request.getName())
                                .withDescription(request.getDescription())
                                .withImg(request.getImg())
                )).orElseThrow(()->new ResourceNotFoundException(ENTITY,OutfitId));
    }

    @Override
    public ResponseEntity<?> Delete(Long OutfitId) {

        return outfitRepository.findById(OutfitId)
                .map(outfit -> {
                    outfitRepository.delete(outfit);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,OutfitId));
    }
}

package pe.edu.upc.raze.consultancies.outfitgenerated.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.consultancies.outfitgenerated.domain.model.entity.OutfitGeneratedModel;
import pe.edu.upc.raze.consultancies.outfitgenerated.domain.persistence.OutfitGeneratedRepository;
import pe.edu.upc.raze.consultancies.outfitgenerated.domain.service.OutfitGeneratedService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class OutfitGeneratedServiceImpl implements OutfitGeneratedService {
    private static final String ENTITY = "OutfitGenerated";

    private final OutfitGeneratedRepository outfitgeneratedRepository;
    private final Validator validator;

    public OutfitGeneratedServiceImpl(OutfitGeneratedRepository outfitgeneratedRepository, Validator validator) {
        this.outfitgeneratedRepository = outfitgeneratedRepository;
        this.validator = validator;
    }

    @Override
    public List<OutfitGeneratedModel> getAll() {
        return outfitgeneratedRepository.findAll();
    }

    @Override
    public Page<OutfitGeneratedModel> getAll(Pageable pageable) {
        return outfitgeneratedRepository.findAll(pageable);
    }

    @Override
    public OutfitGeneratedModel getById(Long outfitgeneratedId) {
        return outfitgeneratedRepository.findById(outfitgeneratedId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, outfitgeneratedId));
    }

    @Override
    public OutfitGeneratedModel create(OutfitGeneratedModel outfitgenerated) {
        Set<ConstraintViolation<OutfitGeneratedModel>> violations = validator.validate(outfitgenerated);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return outfitgeneratedRepository.save(outfitgenerated);
    }

    @Override
    public OutfitGeneratedModel update(Long outfitgeneratedId, OutfitGeneratedModel request) {

        Set<ConstraintViolation<OutfitGeneratedModel>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return outfitgeneratedRepository.findById(outfitgeneratedId).map(profession -> outfitgeneratedRepository.save(
                profession.withTopImage(request.getTopImage())
                        .withBottomImage(request.getBottomImage())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, outfitgeneratedId));

    }

    @Override
    public ResponseEntity<?> delete(Long outfitgeneratedId) {
        return outfitgeneratedRepository.findById(outfitgeneratedId).map(respuesta -> {
            outfitgeneratedRepository.delete(respuesta);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, outfitgeneratedId));
    }
}

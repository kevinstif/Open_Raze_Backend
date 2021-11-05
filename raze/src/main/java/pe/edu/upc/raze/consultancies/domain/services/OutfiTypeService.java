package pe.edu.upc.raze.consultancies.domain.services;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.consultancies.domain.model.entity.OutfiType;

import java.util.List;

public interface OutfiTypeService {
    List<OutfiType> GetAll();
    OutfiType GetById(Long OutfiTypeId);
    OutfiType Create(OutfiType outfiType);
    OutfiType Update(Long OutfiTypeId,OutfiType request);
    ResponseEntity<?> Delete(Long OutfiTypeId);
}

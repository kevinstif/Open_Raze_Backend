package pe.edu.upc.raze.consultancies.domain.services;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.consultancies.domain.model.entity.OutfitTypeService;
import java.util.List;
public interface OutfitTypeService {
    List<OutfitType> GetAll();
    OutfitType GetById(Long OutfitTypeId);
    OutfitType Create(Outfit outfitType);
    OutfitType Update(Long OutfitTypeId,OutfitType request);
    ResponseEntity<?> Delete(Long OutfitTypeId);
}

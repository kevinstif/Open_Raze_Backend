package pe.edu.upc.raze.consultancies.domain.services;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.consultancies.domain.model.entity.Outfit;

import java.util.List;

public interface OutfitService {
    List<Outfit> GetAll();
    Outfit GetById(Long OutfitId);
    Outfit Create(Outfit outfit);
    Outfit Update(Long OutfitId,Outfit request);
    ResponseEntity<?> Delete(Long OutfitId);
}

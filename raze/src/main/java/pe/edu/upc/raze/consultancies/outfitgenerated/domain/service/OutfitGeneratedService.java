package pe.edu.upc.raze.consultancies.outfitgenerated.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.consultancies.outfitgenerated.domain.model.entity.OutfitGeneratedModel;

import java.util.List;

public interface OutfitGeneratedService {
    List<OutfitGeneratedModel> getAll();
    Page<OutfitGeneratedModel> getAll(Pageable pageable);
    OutfitGeneratedModel getById (Long outfitgeneratedId);
    OutfitGeneratedModel create( OutfitGeneratedModel outfitgenerate);
    OutfitGeneratedModel update (Long outfitgeneratedId , OutfitGeneratedModel request );
    ResponseEntity<?> delete (Long outfitgeneratedId);
}

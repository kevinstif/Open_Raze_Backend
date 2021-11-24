package pe.edu.upc.raze.consultancies.footwear.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.consultancies.footwear.domain.model.entity.FootwearModel;

import java.util.List;

public interface FootwearService {
    List<FootwearModel> getAll();
    Page<FootwearModel> getAll(Pageable pageable);
    FootwearModel getById (Long footwearId);
    FootwearModel create( FootwearModel footwear);
    FootwearModel update (Long footwearId , FootwearModel request );
    ResponseEntity<?> delete (Long footwearId);


}

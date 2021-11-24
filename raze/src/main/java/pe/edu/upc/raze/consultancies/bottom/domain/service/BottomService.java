package pe.edu.upc.raze.consultancies.bottom.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.consultancies.bottom.domain.model.entity.BottomModel;

import java.util.List;

public interface BottomService {
    List<BottomModel> getAll();
    Page<BottomModel> getAll(Pageable pageable);
    BottomModel getById (Long bottomId);
    BottomModel create( BottomModel bottom);
    BottomModel update (Long bottomId , BottomModel request );
    ResponseEntity<?> delete (Long bottomId);
}

package pe.edu.upc.raze.consultancies.top.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.consultancies.top.domain.model.entity.TopModel;

import java.util.List;

public interface TopService {
    List<TopModel> getAll();
    Page<TopModel> getAll(Pageable pageable);
    TopModel getById (Long topId);
    TopModel create( TopModel top);
    TopModel update (Long topId , TopModel request );
    ResponseEntity<?> delete (Long topId);
}

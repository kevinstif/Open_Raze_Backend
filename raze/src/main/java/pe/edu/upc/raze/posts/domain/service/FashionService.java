package pe.edu.upc.raze.posts.domain.service;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.posts.domain.model.entity.Fashion;
import java.util.List;

public interface FashionService {
    List<Fashion> getAll();
    Fashion getById(Long fashionId);
    Fashion create(Fashion fashion);
    Fashion update(Long fashionId, Fashion request);
    ResponseEntity<?> delete(Long fashionId);
}

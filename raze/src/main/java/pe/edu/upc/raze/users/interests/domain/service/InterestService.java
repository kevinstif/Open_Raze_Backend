package pe.edu.upc.raze.users.interests.domain.service;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.users.interests.domain.model.entity.Interest;

import java.util.List;

public interface InterestService {
    List<Interest> getAll();
    Interest getById(Long interestId);
    Interest create(Interest interest);
    Interest update(Long interestId, Interest request);
    ResponseEntity<?> delete(Long interestId);
}

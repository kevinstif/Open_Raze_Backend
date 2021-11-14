package pe.edu.upc.raze.posts.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.posts.domain.model.entity.Post;
import pe.edu.upc.raze.users.customers.model.enums.UserType;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    Page<Post> getAll(Pageable pageable);
    List<Post> getAllByUserId(Long userId, UserType userType);
    Post getById(Long postId);
    Post create(Long userId, UserType userType, Post request, Long interestId, Long fashionId);
    Post update(Long userId, Long postId, Post request);
    ResponseEntity<?> delete(Long userId, Long postId, UserType userType);
    Post getByIdAndUserId(Long userId, Long postId, UserType userType);
}

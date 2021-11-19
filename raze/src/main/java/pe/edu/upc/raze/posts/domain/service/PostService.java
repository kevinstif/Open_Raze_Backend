package pe.edu.upc.raze.posts.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.posts.domain.model.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    Page<Post> getAll(Pageable pageable);
    List<Post> getAllByUserId(Long userId);
    Post getById(Long postId);
    Post create(Long userId, Post request, Long interestId, Long fashionId);
    Post update(Long userId, Long postId, Post request);
    ResponseEntity<?> delete(Long userId, Long postId);
    Post getByIdAndUserId(Long userId, Long postId);
}

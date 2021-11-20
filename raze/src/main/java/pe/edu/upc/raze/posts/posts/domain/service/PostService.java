package pe.edu.upc.raze.posts.posts.domain.service;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.posts.posts.domain.model.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    Post getById(Long postId);
    Post create(Post post);
    Post update(Long fashionId, Post post);
    ResponseEntity<?> delete(Long postId);
}

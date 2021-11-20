package pe.edu.upc.raze.posts.posts.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.posts.posts.domain.model.entity.Post;
import pe.edu.upc.raze.posts.posts.domain.persistence.PostRepository;
import pe.edu.upc.raze.posts.posts.domain.service.PostService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PostsServiceImpl implements PostService {

    private static final String ENTITY ="Post";
    private final PostRepository postRepository;
    private final Validator validator;

    public PostsServiceImpl(PostRepository postRepository, Validator validator) {
        this.postRepository = postRepository;
        this.validator = validator;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public Post create(Post post) {
        Set<ConstraintViolation<Post>> violations =validator.validate(post);
        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }
        return postRepository.save(post);
    }

    @Override
    public Post update(Long postId, Post request) {
        Set<ConstraintViolation<Post>> violations =validator.validate(request);
        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);
        }
        return postRepository.findById(postId).map(
                post->postRepository.save(
                        post.withTitle(request.getTitle())
                )).orElseThrow(()->new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public ResponseEntity<?> delete(Long postId) {
        return postRepository.findById(postId).map(
                post -> {
                    postRepository.delete(post);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(()->new ResourceNotFoundException(ENTITY,postId));
    }
}

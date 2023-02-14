package pe.edu.upc.raze.posts.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.posts.domain.model.entity.Post;
import pe.edu.upc.raze.posts.domain.persistence.PostRepository;
import pe.edu.upc.raze.posts.domain.service.PostService;
import pe.edu.upc.raze.security.domain.persistence.UserRepository;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {
    private static final String ENTITY = "Post";
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final Validator validator;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, Validator validator) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> getAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public List<Post> getAllByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public Post getById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public Post create(Long userId, Post request) {
        Set<ConstraintViolation<Post>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return userRepository.findById(userId).map(userAdvised -> {
            request.setUser(userAdvised);
            return postRepository.save(request);
        }).orElseThrow(() -> new ResourceNotFoundException("User", userId));
    }

    @Override
    public Post update(Long userId, Long postId, Post request) {
        Set<ConstraintViolation<Post>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if (!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User", userId);

        if (!postRepository.existsById(postId))
            throw new ResourceNotFoundException("Post", postId);

        return postRepository.findById(postId).map(post -> postRepository.save(post.withTitle(request.getTitle())
                .withImg(request.getImg())
                .withDescription(request.getDescription())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public ResponseEntity<?> delete(Long userId, Long postId) {
        return postRepository.findByIdAndUserId(postId, userId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public Post getByIdAndUserId(Long userId, Long postId) {
        return postRepository.findByIdAndUserId(postId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }
}

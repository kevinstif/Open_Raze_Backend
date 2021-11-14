package pe.edu.upc.raze.posts.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.posts.domain.model.entity.Post;
import pe.edu.upc.raze.posts.domain.persistence.FashionRepository;
import pe.edu.upc.raze.posts.domain.persistence.PostRepository;
import pe.edu.upc.raze.posts.domain.service.PostService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;
import pe.edu.upc.raze.users.customers.model.enums.UserType;
import pe.edu.upc.raze.users.customers.userAdvised.domain.persistence.UserAdvisedRepository;
import pe.edu.upc.raze.users.customers.userAdvisors.domain.persistence.UserAdvisorRepository;
import pe.edu.upc.raze.users.interests.domain.persistence.InterestRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {
    private static final String ENTITY = "Post";
    private final PostRepository postRepository;
    private final UserAdvisedRepository userAdvisedRepository;
    private final UserAdvisorRepository userAdvisorRepository;
    private final FashionRepository fashionRepository;
    private final InterestRepository interestRepository;
    private final Validator validator;

    public PostServiceImpl(PostRepository postRepository, UserAdvisedRepository userAdvisedRepository,
                           UserAdvisorRepository userAdvisorRepository, FashionRepository fashionRepository,
                           InterestRepository interestRepository, Validator validator) {
        this.postRepository = postRepository;
        this.userAdvisedRepository = userAdvisedRepository;
        this.userAdvisorRepository = userAdvisorRepository;
        this.fashionRepository = fashionRepository;
        this.interestRepository = interestRepository;
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
    public List<Post> getAllByUserId(Long userId, UserType userType) {
        if(userType == UserType.Advised) return postRepository.findByUserAdvisedId(userId);
        return postRepository.findByUserAdvisorId(userId);
    }

    @Override
    public Post getById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public Post create(Long userId, UserType userType, Post request, Long interestId, Long fashionId) {
        Set<ConstraintViolation<Post>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        fashionRepository.findById(fashionId).map(fashion -> {
            request.setFashion(fashion);
            return request;
        }).orElseThrow(() -> new ResourceNotFoundException("Fashion", fashionId));

        interestRepository.findById(interestId).map(interest -> {
            request.setInterest(interest);
            return request;
        }).orElseThrow(() -> new ResourceNotFoundException("Interest", interestId));

        if(userType == UserType.Advised){
            return userAdvisedRepository.findById(userId).map(userAdvised -> {
                request.setUserAdvised(userAdvised);
                return postRepository.save(request);
            }).orElseThrow(() -> new ResourceNotFoundException("User", userId));
        }
        return userAdvisorRepository.findById(userId).map(userAdvisor -> {
            request.setUserAdvisor(userAdvisor);
            return postRepository.save(request);
        }).orElseThrow(() -> new ResourceNotFoundException("User", userId));
    }

    @Override
    public Post update(Long userId, Long postId, Post request) {
        Set<ConstraintViolation<Post>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!userAdvisorRepository.existsById(userId) && !userAdvisedRepository.existsById(userId)){
            throw new ResourceNotFoundException("User", userId);
        }

        return postRepository.findById(postId).map(post ->
            postRepository.save(post.withId(request.getId()))
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public ResponseEntity<?> delete(Long userId, Long postId, UserType userType) {
        if(userType == UserType.Advised){
            return postRepository.findByIdAndUserAdvisedId(postId, userId).map(post -> {
                postRepository.delete(post);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
        }
        return postRepository.findByIdAndUserAdvisorId(postId, userId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public Post getByIdAndUserId(Long userId, Long postId, UserType userType) {
        if(userType == UserType.Advised){
            return postRepository.findByIdAndUserAdvisedId(postId, userId)
                    .orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
        }
        return postRepository.findByIdAndUserAdvisorId(postId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }
}

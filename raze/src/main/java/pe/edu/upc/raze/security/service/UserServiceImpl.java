package pe.edu.upc.raze.security.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.security.domain.model.entity.User;
import pe.edu.upc.raze.security.domain.persistence.UserRepository;
import pe.edu.upc.raze.security.domain.service.UserService;
import pe.edu.upc.raze.security.domain.service.communication.AuthenticateRequest;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final String ENTITY = "User";
    private final UserRepository userRepository;
    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User register(User request) {
        Set<ConstraintViolation<User>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return userRepository.save(request);
    }

    @Override
    public ResponseEntity<?> authenticate(AuthenticateRequest request) {
        return null;
    }

    @Override
    public User update(Long userId, User request) {
        Set<ConstraintViolation<User>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return userRepository.findById(userId).map(user ->
                userRepository.save(
                        user.withName(request.getName())
                            .withImgProfile(request.getImgProfile())
                            .withAge(request.getAge())
                            .withPassword(request.getPassword())
                            .withPremium(request.isPremium())
                            .withYearsExperience(request.getYearsExperience())
                )
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public ResponseEntity<?> delete(Long userId) {
        return userRepository.findById(userId).map(post -> {
            userRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

    //@Override
    //public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //    User user = userRepository.findByUsername(username)
    //            .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with username: %s", username)));
    //    return UserDetailsImpl.build(user);
    //}
}

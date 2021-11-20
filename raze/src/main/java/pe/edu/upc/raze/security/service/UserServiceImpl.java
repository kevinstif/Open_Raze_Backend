package pe.edu.upc.raze.security.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.security.domain.model.entity.User;
import pe.edu.upc.raze.security.domain.persistence.UserRepository;
import pe.edu.upc.raze.security.domain.service.UserService;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;
import pe.edu.upc.raze.users.interests.domain.persistence.InterestRepository;
import pe.edu.upc.raze.users.professions.domain.persistence.ProfessionRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final String ENTITY = "User";
    private final UserRepository userRepository;
    private final InterestRepository interestRepository;
    private final ProfessionRepository professionRepository;
    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, InterestRepository interestRepository, ProfessionRepository professionRepository, Validator validator) {
        this.userRepository = userRepository;
        this.interestRepository = interestRepository;
        this.professionRepository = professionRepository;
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
    public User register(User request, Long interestId, Long professionId) {
        Set<ConstraintViolation<User>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        interestRepository.findById(interestId).map(interest -> {
            request.setInterest(interest);
            return request;
        }).orElseThrow(() -> new ResourceNotFoundException("Interest", interestId));

        if(professionId != null){
            professionRepository.findById(professionId).map(profession -> {
                request.setProfession(profession);
                return request;
            }).orElseThrow(() -> new ResourceNotFoundException("Profession", interestId));
        }

        return userRepository.save(request);
    }

    //@Override
    //public ResponseEntity<?> authenticate(AuthenticateRequest request) {
    //    return null;
    //}

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

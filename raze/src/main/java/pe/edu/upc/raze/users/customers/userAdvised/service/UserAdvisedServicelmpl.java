package pe.edu.upc.raze.users.customers.userAdvised.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;
import pe.edu.upc.raze.users.customers.userAdvised.domain.model.entity.UserAdvised;
import pe.edu.upc.raze.users.customers.userAdvised.domain.persistence.UserAdvisedRepository;
import pe.edu.upc.raze.users.customers.userAdvised.domain.services.UserAdvisedService;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UserAdvisedServicelmpl implements UserAdvisedService {

    private static final String ENTITY="UserAdvised";
    private final UserAdvisedRepository userAdvisedRepository;
    private final Validator validator;


    public UserAdvisedServicelmpl(UserAdvisedRepository userAdvisedRepository,Validator validator) {
        this.userAdvisedRepository = userAdvisedRepository;
        this.validator=validator;
    }

    @Override
    public List<UserAdvised> GetAll() {
        return userAdvisedRepository.findAll();
    }

    @Override
    public UserAdvised GetById(Long UserAdvisedId) {
        return userAdvisedRepository.findById(UserAdvisedId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,UserAdvisedId));
    }

    @Override
    public UserAdvised Create(UserAdvised request) {

        Set<ConstraintViolation<UserAdvised>> violations= validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        return userAdvisedRepository.save(request);
    }

    @Override
    public UserAdvised Update(Long UserAdvisedId, UserAdvised request) {

        Set<ConstraintViolation<UserAdvised>> violations= validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        var userAdvisedUpdate=userAdvisedRepository.findById(UserAdvisedId)
                .map(userAdvised->userAdvisedRepository.save(
                        userAdvised.withMood(request.getMood())

                )).orElseThrow(()->new ResourceNotFoundException(ENTITY,UserAdvisedId));

        return userAdvisedUpdate;
    }

    @Override
    public ResponseEntity<?> Delete(Long UserAdvisedId) {

        return userAdvisedRepository.findById(UserAdvisedId)
                .map(userAdvised -> {
                    userAdvisedRepository.delete(userAdvised);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,UserAdvisedId));
    }
}
package pe.edu.upc.raze.users.customers.userAdvisors.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;
import pe.edu.upc.raze.shared.exception.ResourceValidationException;
import pe.edu.upc.raze.users.customers.userAdvisors.domain.model.entity.UserAdvisor;
import pe.edu.upc.raze.users.customers.userAdvisors.domain.persistence.UserAdvisorRepository;
import pe.edu.upc.raze.users.customers.userAdvisors.domain.services.UserAdvisorService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UserAdvisorServicelmpl  implements UserAdvisorService {
    private static final String ENTITY="UserAdvisor";
    private final UserAdvisorRepository userAdvisorRepository;
    private final Validator validator;

    public UserAdvisorServicelmpl(UserAdvisorRepository userAdvisorRepository, Validator validator) {
        this.userAdvisorRepository = userAdvisorRepository;
        this.validator=validator;
    }


    @Override
    public List<UserAdvisor> GetAll() {
        return userAdvisorRepository.findAll();
    }

    @Override
    public UserAdvisor GetById(Long UserAdvisorId) {
        return userAdvisorRepository.findById(UserAdvisorId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY,UserAdvisorId));
    }

    @Override
    public UserAdvisor Create(UserAdvisor request) {

        Set<ConstraintViolation<UserAdvisor>> violations= validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        return userAdvisorRepository.save(request);
    }

    @Override
    public UserAdvisor Update(Long UserAdvisorId, UserAdvisor request) {

        Set<ConstraintViolation<UserAdvisor>> violations= validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        var userAdvisorUpdate=userAdvisorRepository.findById(UserAdvisorId)
                .map(userAdvisor->userAdvisorRepository.save(
                        userAdvisor.withYearExperience(request.getYearExperience())

                )).orElseThrow(()->new ResourceNotFoundException(ENTITY,UserAdvisorId));

        return userAdvisorUpdate;
    }

    @Override
    public ResponseEntity<?> Delete(Long UserAdvisorId) {

        return userAdvisorRepository.findById(UserAdvisorId)
                .map(userAdvisor -> {
                    userAdvisorRepository.delete(userAdvisor);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,UserAdvisorId));
    }
}
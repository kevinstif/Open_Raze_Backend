package pe.edu.upc.raze.security.service;

import io.jsonwebtoken.JwtHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.security.domain.model.entity.User;
import pe.edu.upc.raze.security.domain.persistence.RoleRepository;
import pe.edu.upc.raze.security.domain.persistence.UserRepository;
import pe.edu.upc.raze.security.domain.service.UserService;
import pe.edu.upc.raze.security.domain.service.communication.AuthenticateRequest;
import pe.edu.upc.raze.security.domain.service.communication.RegisterRequest;
import pe.edu.upc.raze.shared.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String ENTITY = "User";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    //private final JwtHandler handler;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseEntity<?> authenticate(AuthenticateRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> register(RegisterRequest request) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User update(Long userId, User request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long userId) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}

package pe.edu.upc.raze.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pe.edu.upc.raze.security.domain.model.entity.User;
import pe.edu.upc.raze.security.domain.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);



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
        return null;
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

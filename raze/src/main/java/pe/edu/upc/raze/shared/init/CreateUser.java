package pe.edu.upc.raze.shared.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.security.domain.model.entity.User;
import pe.edu.upc.raze.security.domain.persistence.AuthorityRepository;
import pe.edu.upc.raze.security.domain.persistence.UsuarioRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class CreateUser implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        User juan = new User();
        juan.setUsername("juan123");
        juan.setPassword(passwordEncoder.encode("juan123"));
        juan.setPremium(true);
        juan.setLast_name("Lopez");
        juan.setFirst_name("Juan");
        juan.setUser_type("Advisor");
        juan.addAuthority("ROLE_ADVISOR");
        juan.addAuthority("ACCESS_OUTFITS");

        User luis = new User();
        luis.setUsername("lucho5");
        luis.setPassword(passwordEncoder.encode("lucho5"));
        luis.setPremium(true);
        luis.setLast_name("Advincula");
        luis.setFirst_name("Luis");
        luis.setUser_type("Advised");
        luis.addAuthority("ROLE_ADVISED");
        luis.addAuthority("ACCESS_INTERESTS");

        List<User> usuarios = Arrays.asList(juan, luis);
        this.usuarioRepository.saveAll(usuarios);

    }
}

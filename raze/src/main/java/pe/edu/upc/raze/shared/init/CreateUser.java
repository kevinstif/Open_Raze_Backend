package pe.edu.upc.raze.shared.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.raze.security.domain.model.entity.Usuario;
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

        //COMENTAR DESPUÉS DE EJECUTAR POR PRIMERA VEZ
        Usuario juan = new Usuario();
        juan.setUsername("Juan");
        juan.setPassword(passwordEncoder.encode("Juan"));
        juan.setEnable(true);
        juan.setApellidos("Lopez");
        juan.setNombres("juan");
        juan.setCargo("Advisor");
        juan.addAuthority("ROLE_ADVISOR");
        juan.addAuthority("ACCESS_OUTFITS");

        Usuario luis = new Usuario();
        luis.setUsername("Luis");
        luis.setPassword(passwordEncoder.encode("Luis"));
        luis.setEnable(true);
        luis.setApellidos("Advincula");
        luis.setNombres("lucho");
        luis.setCargo("Advised");
        luis.addAuthority("ROLE_ADVISED");
        luis.addAuthority("ACCESS_INTERESTS");

        List<Usuario> usuarios = Arrays.asList(juan, luis);
        this.usuarioRepository.saveAll(usuarios);

    }
}

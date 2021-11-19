package pe.edu.upc.raze.security.mapping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("UserConfiguration")
public class MappingConfiguration {
    @Bean
    public UserMapper userMapper(){return new UserMapper();}
}
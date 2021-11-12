package pe.edu.upc.raze.users.customers.userAdvisors.mapping;

import org.springframework.context.annotation.Bean;
import pe.edu.upc.raze.users.customers.userAdvised.mapping.UserAdvisedMapper;

public class MappingConfiguration {
    @Bean
    public UserAdvisorMapper userAdvisorMapper(){return new UserAdvisorMapper();}
}
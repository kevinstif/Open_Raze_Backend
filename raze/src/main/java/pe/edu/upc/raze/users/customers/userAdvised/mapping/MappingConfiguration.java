package pe.edu.upc.raze.users.customers.userAdvised.mapping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.upc.raze.consultancies.outfits.mapping.OutfitMapper;
@Configuration("UserAdvisedConfiguration")
public class MappingConfiguration {
    @Bean
    public UserAdvisedMapper userAdvisedMapper(){return new UserAdvisedMapper();}
}
package pe.edu.upc.raze.users.professions.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ProfessionMapper professionMapperMapper() {

        return new ProfessionMapper();
    }
}

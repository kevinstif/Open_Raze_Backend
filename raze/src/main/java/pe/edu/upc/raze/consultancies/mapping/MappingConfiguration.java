package pe.edu.upc.raze.consultancies.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("consultanciesMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public OutfiTypeMapper outfiTypeMapper(){return new OutfiTypeMapper();}
}

package pe.edu.upc.raze.consultancies.outfiType.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("consultanciesOutfitTypesMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public OutfiTypeMapper outfiTypeMapper(){return new OutfiTypeMapper();}
}

package pe.edu.upc.raze.consultancies.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("consultanciesMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public OutfitMapper outfitMapper(){return new OutfitMapper();}
}

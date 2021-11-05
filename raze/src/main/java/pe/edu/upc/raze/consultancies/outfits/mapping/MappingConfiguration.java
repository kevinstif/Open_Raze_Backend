package pe.edu.upc.raze.consultancies.outfits.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("consultanciesOutfitMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public OutfitMapper outfitMapper(){return new OutfitMapper();}
}

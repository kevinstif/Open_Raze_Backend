package pe.edu.upc.raze.consultancies.outfitgenerated.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("consultanciesOutfitGeneratedMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public OutfitGeneratedMapper outfitgeneratedMapperMapper(){
        return new OutfitGeneratedMapper();
    }
}

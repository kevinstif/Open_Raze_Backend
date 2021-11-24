package pe.edu.upc.raze.consultancies.footwear.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("consultanciesFootwearMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public FootwearMapper footwearMapperMapper(){
        return new FootwearMapper();
    }
}

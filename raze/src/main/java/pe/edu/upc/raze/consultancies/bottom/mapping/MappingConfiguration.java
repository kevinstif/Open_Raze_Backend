package pe.edu.upc.raze.consultancies.bottom.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("consultanciesBottomMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public BottomMapper bottomMapperMapper(){
        return new BottomMapper();
    }
}

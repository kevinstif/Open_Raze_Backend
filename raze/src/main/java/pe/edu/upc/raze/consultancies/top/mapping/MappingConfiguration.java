package pe.edu.upc.raze.consultancies.top.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("consultanciesTopMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TopMapper topMapperMapper(){
        return new TopMapper();
    }
}

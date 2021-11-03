package pe.edu.upc.raze.users.interests.mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("PostMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public InterestMapper interestMapper(){ return new InterestMapper(); }
}

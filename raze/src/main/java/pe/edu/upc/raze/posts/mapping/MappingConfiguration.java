package pe.edu.upc.raze.posts.mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("PostMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public FashionMapper fashionMapper(){
        return new FashionMapper();
    }
}

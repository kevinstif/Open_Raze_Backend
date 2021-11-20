package pe.edu.upc.raze.posts.fashions.mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("FashionMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public FashionMapper fashionMapper(){
        return new FashionMapper();
    }
}

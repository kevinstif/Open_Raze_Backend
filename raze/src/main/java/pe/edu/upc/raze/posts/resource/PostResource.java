package pe.edu.upc.raze.posts.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResource {
    private Long id;
    private String title;
    private String image;
    private String description;
    private Float rate;
    private Integer numberOfRates;
}

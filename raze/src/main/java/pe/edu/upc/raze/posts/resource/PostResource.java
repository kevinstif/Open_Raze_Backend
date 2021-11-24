package pe.edu.upc.raze.posts.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResource {
    private Long id;
    private String title;
    private String img;
    private String description;
    private Long userId;
}

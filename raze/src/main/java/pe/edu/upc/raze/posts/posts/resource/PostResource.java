package pe.edu.upc.raze.posts.posts.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PostResource {

    private Long id;

    private String title;

    private String img;

    private String description;
}

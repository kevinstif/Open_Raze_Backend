package pe.edu.upc.raze.posts.posts.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class UpdatePostResource {

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String img;

    @NotNull
    private String description;
}

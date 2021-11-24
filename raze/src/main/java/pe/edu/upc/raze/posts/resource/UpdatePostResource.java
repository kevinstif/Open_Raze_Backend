package pe.edu.upc.raze.posts.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdatePostResource {
    private Long id;

    @NotNull
    @Size(max = 70)
    private String title;

    @NotNull
    private String img;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    private Long userId;
}

package pe.edu.upc.raze.posts.posts.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreatedPostResource {
    @NotNull
    private String title;

    @NotNull
    private String img;

    @NotNull
    private String description;

    @NotNull
    private Long outfitId;

}

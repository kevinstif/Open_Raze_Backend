package pe.edu.upc.raze.posts.fashions.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateFashionResource {
    @NotNull
    @Size(max = 20)
    private String title;
}

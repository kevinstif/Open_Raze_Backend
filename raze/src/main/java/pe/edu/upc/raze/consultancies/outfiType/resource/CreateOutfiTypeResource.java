package pe.edu.upc.raze.consultancies.outfiType.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateOutfiTypeResource {

    @NotNull
    @Size(max = 20)
    private String title;

    @NotNull
    @Size(max = 250)
    private String urlToImage;

    @NotNull
    private String description;
}

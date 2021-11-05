package pe.edu.upc.raze.consultancies.outfiType.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateOutfiTypeResource {

    private Long id;

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    @Size(max = 250)
    private String url;

    @NotNull
    private String description;
}

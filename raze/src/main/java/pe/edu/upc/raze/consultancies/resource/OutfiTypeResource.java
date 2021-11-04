package pe.edu.upc.raze.consultancies.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class OutfiTypeResource {
    private Long id;
    @Size(max = 30)
    private String name;
    private String url;
    private String description;
}

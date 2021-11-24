package pe.edu.upc.raze.consultancies.footwear.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateFootwearResource {
    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 10000)
    private String image;
}

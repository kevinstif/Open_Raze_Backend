package pe.edu.upc.raze.consultancies.outfits.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateOutfitResource {

    private Long id;

    @NotNull
    @Size(max = 20)
    private String name;

    @NotNull
    @Size(max = 250)
    private String img;

    @NotNull
    private String description;
}

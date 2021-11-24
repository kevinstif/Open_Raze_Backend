package pe.edu.upc.raze.consultancies.outfitgenerated.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
public class CreateOutfitGeneratedResource {
    @NotNull
    private Long userId;

    @Size(max = 10000)
    private String topImage;

    @Size(max = 10000)
    private String bottomImage;

    @Size(max = 10000)
    private String footWearImage;
}

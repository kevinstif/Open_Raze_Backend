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
    private String image;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    private Float rate;

    @NotNull
    private Integer numberOfRates;

    @NotNull
    private Long userId;

    @NotNull
    private Long interestId;

    @NotNull
    private Long fashionId;
}

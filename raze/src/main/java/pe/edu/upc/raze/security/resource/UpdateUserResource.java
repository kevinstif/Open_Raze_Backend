package pe.edu.upc.raze.security.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateUserResource {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String imgProfile;

    @NotNull
    private Integer age;

    @NotNull
    @NotBlank
    private String password;

    protected boolean premium;

    private Integer yearsExperience;
}

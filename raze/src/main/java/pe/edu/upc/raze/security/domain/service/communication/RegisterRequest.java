package pe.edu.upc.raze.security.domain.service.communication;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RegisterRequest {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String imgProfile;

    @NotNull
    private Integer age;

    @NotNull
    private Long interestId;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    private String password;

    protected boolean premium;

    @NotNull
    @NotBlank
    private String userType;

    private Integer yearsExperience;
    private Long professionId;
}

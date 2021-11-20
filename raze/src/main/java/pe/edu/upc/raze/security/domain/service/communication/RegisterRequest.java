package pe.edu.upc.raze.security.domain.service.communication;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
public class RegisterRequest {
    private Long id;

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
    private String user_type;

    @Null
    private Integer yearsExperience;
    @Null
    private Long professionId;

    public Long getProfessionId() { return professionId; }
    public Long getInterestId() { return interestId; }
}

package pe.edu.upc.raze.users.customers.userAdvisors.resources;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateUserAdvisorResource {

    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    private String lastName;
    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    private String username;

    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    private String password;


    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    private String age;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private Long yearExperience;
}
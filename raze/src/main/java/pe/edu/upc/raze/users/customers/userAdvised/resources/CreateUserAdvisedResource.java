package pe.edu.upc.raze.users.customers.userAdvised.resources;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class CreateUserAdvisedResource {


    @NotBlank
    @Size(max=50)
    private String firstName;


    @NotBlank
    @Size(max=50)
    private String lastName;


    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(max=50)
    private String password;


    @NotNull
    private Long age;

    @NotNull
    private Long mood;
}
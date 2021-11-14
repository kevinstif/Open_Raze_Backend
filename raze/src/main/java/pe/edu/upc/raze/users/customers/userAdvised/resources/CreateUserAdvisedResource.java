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

    @NotNull
    @Size(max=50)
    private String firstName;

    @NotNull
    @Size(max=50)
    private String lastName;

    @NotNull
    @Size(max=50)
    private String username;

    @NotNull
    @Size(max=50)
    private String password;


    @NotNull
    @Size(max=50)
    private String age;

    @NotNull
    private Long mood;


}
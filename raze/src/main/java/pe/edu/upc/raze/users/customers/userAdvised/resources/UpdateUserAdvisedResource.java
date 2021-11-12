package pe.edu.upc.raze.users.customers.userAdvised.resources;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserAdvisedResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max=50)
    private String firstName;

    @NotNull
    @Size(max=50)
    private String lastName;

    @NotNull
    @Size(max=50)
    private String username;

    @NotNull
    private String password;


    @NotNull
    private Long age;

    @NotNull
    private Boolean premium;

    @NotNull
    private Long mood;

    @NotNull
    private Long yearExperience;
}
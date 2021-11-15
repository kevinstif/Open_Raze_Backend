package pe.edu.upc.raze.users.customers.userAdvised.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAdvisedResource {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Long age;
    private Boolean premium;
    private Long mood;
}
package pe.edu.upc.raze.security.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResource {
    private Long id;
    private String name;
    private String username;
    private String imgProfile;
    private Integer age;
    private String email;
    private String password;
    private boolean premium;
    private String userType;
    private Integer yearsExperience;
}

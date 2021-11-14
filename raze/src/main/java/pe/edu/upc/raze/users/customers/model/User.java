package pe.edu.upc.raze.users.customers.model;
import lombok.*;
import javax.persistence.*;

import pe.edu.upc.raze.posts.domain.model.entity.Post;
import pe.edu.upc.raze.shared.domain.model.AuditModel;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class User  extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    protected String firstName;

    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    protected String lastName;
    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    protected String username;

    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    protected String password;


    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    protected Long age;

    @OneToMany
    protected List<Post> posts;

    @NotNull
    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    private Boolean premium;
}
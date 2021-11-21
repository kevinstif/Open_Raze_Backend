package pe.edu.upc.raze.users.interests.domain.model.entity;

import lombok.*;
import pe.edu.upc.raze.posts.domain.model.entity.Post;
import pe.edu.upc.raze.security.domain.model.entity.User;
import pe.edu.upc.raze.shared.domain.model.AuditModel;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "interests")

public class Interest extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String description;

    @OneToMany
    private List<Post> posts;

    @OneToMany
    private List<User> users;
}

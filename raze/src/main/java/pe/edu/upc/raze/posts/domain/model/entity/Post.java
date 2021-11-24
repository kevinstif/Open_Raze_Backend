package pe.edu.upc.raze.posts.domain.model.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import pe.edu.upc.raze.security.domain.model.entity.User;
import pe.edu.upc.raze.shared.domain.model.AuditModel;
import pe.edu.upc.raze.users.interests.domain.model.entity.Interest;

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
@Table(name = "posts")
public class Post extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 70)
    private String title;

    @NotNull
    @NotBlank
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String image;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = true)
    private User user = null;
}

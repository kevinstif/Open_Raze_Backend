package pe.edu.upc.raze.posts.domain.model.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import pe.edu.upc.raze.shared.domain.model.AuditModel;
import pe.edu.upc.raze.users.customers.userAdvised.domain.model.entity.UserAdvised;
import pe.edu.upc.raze.users.customers.userAdvisors.domain.model.entity.UserAdvisor;
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

    @NotNull
    private Float rate;

    @NotNull
    private Integer numberOfRates;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "advised_id", nullable = false)
    private UserAdvised userAdvised;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "advisor_id", nullable = false)
    private UserAdvisor userAdvisor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "interest_id", nullable = false)
    private Interest interest;

    @ManyToOne
    @JoinColumn(name = "fashion_id", nullable = false)
    private Fashion fashion;

    @OneToMany
    private List<Comment> comments;
}

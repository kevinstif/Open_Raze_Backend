package pe.edu.upc.raze.posts.posts.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pe.edu.upc.raze.consultancies.outfits.domain.model.entity.Outfit;
import pe.edu.upc.raze.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    private String title;

    @NotNull
    @NotBlank
    private String img;

    @NotNull
    @NotBlank
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "outfit_id", nullable = false)
    @JsonIgnore
    private Outfit outfit;

}

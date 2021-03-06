package pe.edu.upc.raze.consultancies.outfits.domain.model.entity;

import pe.edu.upc.raze.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "outfits")
public class Outfit extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 20)
    @Column(unique = true)
    private String name;

    @NotNull
    @NotBlank
    @Size(max=250)
    private String img;

    @NotNull
    @NotBlank
    private String description;

}

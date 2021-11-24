package pe.edu.upc.raze.consultancies.outfitgenerated.domain.model.entity;

import lombok.*;
import pe.edu.upc.raze.shared.domain.model.AuditModel;
import org.hibernate.annotations.Type;

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
@Table(name = "outfitgenerated")

public class OutfitGeneratedModel extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @NotNull
    private Long userId;

    @Size(max = 10000)
    private String topImage;

    @Size(max = 10000)
    private String bottomImage;

    @Size(max = 10000)
    private String footWearImage;

}

package pe.edu.upc.raze.consultancies.footwear.domain.model.entity;

import lombok.*;
import pe.edu.upc.raze.shared.domain.model.AuditModel;

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
@Table(name = "footwears")
public class FootwearModel extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String name;


    @NotNull
    @NotBlank
    @Size(max = 10000)
    private String image;
}

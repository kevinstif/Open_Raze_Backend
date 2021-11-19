package pe.edu.upc.raze.security.domain.model.entity;
import lombok.*;
import pe.edu.upc.raze.security.domain.model.enumeration.Roles;
import pe.edu.upc.raze.shared.domain.model.AuditModel;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "roles")
public class Role extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;
}

package pe.edu.upc.raze.posts.domain.model.entity;

import lombok.*;
import pe.edu.upc.raze.shared.domain.model.AuditModel;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "comments")
public class Comment extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

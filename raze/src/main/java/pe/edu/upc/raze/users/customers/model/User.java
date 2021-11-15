package pe.edu.upc.raze.users.customers.model;
import lombok.*;
import javax.persistence.*;
import pe.edu.upc.raze.shared.domain.model.AuditModel;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotBlank
    @Size(max=50)
    protected String firstName;

    @NotBlank
    @Size(max=50)
    protected String lastName;

    @NotBlank
    @Size(max=50)
    @Column(unique = true)
    protected String username;

    @NotBlank
    @Size(max=50)
    protected String password;

    @NotNull
    protected Long age;

}
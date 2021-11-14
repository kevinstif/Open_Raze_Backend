package pe.edu.upc.raze.users.customers.userAdvised.domain.model.entity;

import lombok.*;
import pe.edu.upc.raze.users.customers.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_adviseds")
public class UserAdvised  extends User {

    @NotNull
    private Long mood;


}
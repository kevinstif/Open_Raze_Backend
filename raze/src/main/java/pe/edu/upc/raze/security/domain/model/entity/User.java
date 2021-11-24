package pe.edu.upc.raze.security.domain.model.entity;

import lombok.*;
import pe.edu.upc.raze.posts.domain.model.entity.Post;
import pe.edu.upc.raze.users.interests.domain.model.entity.Interest;
import pe.edu.upc.raze.users.professions.domain.model.entity.ProfessionModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name = "users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(length = 40, nullable = false)
	private String name;

    @Column(length = 30, nullable = false, unique = true)
    private String username;

	@Column(nullable = false)
	private String imgProfile;

	@Column(nullable = false)
	private Integer age;

	@Column(length = 60, nullable = false, unique = true)
	private String email;

    @Column(length = 60, nullable = false)
    private String password;

    private boolean premium;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "interest_id", nullable = false)
	private Interest interest;

	@Column(length = 30, nullable = false)
	private String user_type;

	@Column(nullable = true)
	private Integer yearsExperience;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "profession_id", nullable = true)
	private ProfessionModel profession;

	@OneToMany
	private List<Post> posts;
    //private List<Authority> authorities;
}

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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "profession_id", nullable = true)
	private ProfessionModel profession;

	@OneToMany
	private List<Post> posts;
    
    //@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //private List<Authority> authorities;

	//public User() {
	//	this.premium = true;
	//	this.authorities = new ArrayList<>();
	//}
	//public User(String username, String password ) {
	//	this.username = username;
	//	this.password = password;
	//	this.premium = true;
	//	this.authorities = new ArrayList<>();
	//}

	//public void addAuthority( String _authority ) {
	//	Authority authority = new Authority();
	//	authority.setAuthority( _authority );
	//	authority.setUsuario(this);
	//	this.authorities.add(authority);
	//}

	//public long getId() {
	//	return id;
	//}
//
	//public void setId(long id) {
	//	this.id = id;
	//}

	//public String getUsername() {
	//	return username;
	//}
//
	//public void setUsername(String username) {
	//	this.username = username;
	//}
//
	//public String getPassword() {
	//	return password;
	//}
//
	//public void setPassword(String password) {
	//	this.password = password;
	//}
//
	//public boolean isPremium() {
	//	return premium;
	//}
//
	//public void setPremium(boolean premium) {
	//	this.premium = premium;
	//}

	//public List<Authority> getAuthorities() {
	//	return authorities;
	//}

	//public void setAuthorities(List<Authority> authorities) {
	//	this.authorities = authorities;
	//}
	//public String getName() {
	//	return name;
	//}
	//public void setName(String name) {
	//	this.name = name;
	//}
	//public String getUser_type() {
	//	return user_type;
	//}
	//public void setUser_type(String user_type) {
	//	this.user_type = user_type;
	//}
}

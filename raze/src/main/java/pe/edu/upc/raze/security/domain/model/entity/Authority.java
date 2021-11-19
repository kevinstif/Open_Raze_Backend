package pe.edu.upc.raze.security.domain.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "authority"})})
public class Authority {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 30, nullable = false)
    private String authority;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")    
    private User usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User user) {
		this.usuario = user;
	}
 
    
}

package pe.edu.upc.raze.security.config.spring;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pe.edu.upc.raze.security.domain.model.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Implementación de una clase detail que manipula al usuario
public class UsuarioDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// @Autowired
	private User user;
	public UsuarioDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		// Extraer la lista de las Authorities
		this.user.getAuthorities().forEach(authority -> {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
			grantedAuthorities.add(grantedAuthority);
		});

		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.isPremium();
	}
	
	// Datos de la Clase Usuario
	public String getName() {
		return this.user.getName();
	}
	public String getUser_type() {
		return this.user.getUser_type();
	}

}

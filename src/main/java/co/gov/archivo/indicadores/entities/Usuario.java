package co.gov.archivo.indicadores.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "auth_usuarios")
public class Usuario implements UserDetails, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_name", length = 200, nullable = false, unique = true)
	private String userName;
	
	@Column(name = "password", length = 200, nullable = false)
	private String password;
		
	@CreatedDate
	@Column(name = "fecha_creacion", nullable = false, updatable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_habilita")
	private Date fechaHabilita;
	
	@CreatedDate
	@Column(name = "ultimo_acceso")
	private Date ultimoAcceso;
	
	@Column(name = "estado_login")
	private Boolean estadoLogin;
		
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estado", nullable = false)
	private Parametro estado;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("Admin"));
	}
	
	public Usuario(Long id){
		this.id = id;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}

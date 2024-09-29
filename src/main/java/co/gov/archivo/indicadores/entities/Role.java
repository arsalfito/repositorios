package co.gov.archivo.indicadores.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "auth_roles")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 200, nullable = false)
	private String name;
	
	@Column(name = "descripcion", length = 200, nullable = false)
	private String description;

	@Column(name = "role_por_defecto", nullable = false)
	private Boolean defaultRole;
	
	@Column(name = "role_asigna_ti", nullable = false)
	private Boolean roleAssignsTi;
	
	@Column(name = "is_admin", nullable = false)
	private Boolean isAdmin;
	
	@Column(name = "codigo", length = 10)
	private String code;
	
	public Role(Long id){
		this.id = id;
	}
	
}

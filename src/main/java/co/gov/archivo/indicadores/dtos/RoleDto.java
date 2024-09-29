package co.gov.archivo.indicadores.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RoleDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long idRole;
	private String name;
	private String code;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)	
	private Long applicationId;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String description;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Boolean roleAssignsTi;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Boolean isAdmin;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Boolean defaultRole;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private List<MenuDto> menu;
}

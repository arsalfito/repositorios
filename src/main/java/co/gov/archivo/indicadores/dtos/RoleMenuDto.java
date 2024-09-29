package co.gov.archivo.indicadores.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RoleMenuDto {	
	private Long menuId;
	private Long roleId;
	private Boolean state;
	private Integer level;	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private MenuDto menu;
}

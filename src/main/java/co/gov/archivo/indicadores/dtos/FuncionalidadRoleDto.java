package co.gov.archivo.indicadores.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FuncionalidadRoleDto {
	private Boolean state;	
	private Long funtionalityId;	
	private Long roleMenuId;
}

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
public class AplicacionesUsuarioDto {	
			
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long idUser;
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long idApplication;
	private String application;	
	private Long idRole;
	private String role;
}

package co.gov.archivo.indicadores.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FuncionalidadDto {
	private Long id;
	private String functionality;
	private String description;
	private Boolean state;
	private Long idMenu;
}
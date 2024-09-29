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
public class CategoryDto {
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;
	private String name;    
	private String description;
	private String code;
	private Boolean state;		
	private String icon;
	private Long applicationId;
	private String application;
}

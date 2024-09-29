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
public class MenuDto {

	private Long id;	
	private String name;	
	private String title;	
	private String description;
	private Boolean state;
	private String path;
	private Boolean visible;
	private String icon;
	private Integer order;			
	private Long categoryId;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String category;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long idApplication;
}

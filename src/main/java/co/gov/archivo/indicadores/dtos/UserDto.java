package co.gov.archivo.indicadores.dtos;

import java.util.Date;
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
public class UserDto {
	private Long id;	
	private Long documentType;
	private String document;	
	private Long personTypeId;
	private String name1;
	private String name2;
	private String lastName1;
	private String lastName2;
	private String fullName;
	private String userName;
	private String mail;
	private String password;
	private Date lastAccess;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String documentTypeName;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long idApplication;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private List<AplicacionesUsuarioDto> appsUser;
}

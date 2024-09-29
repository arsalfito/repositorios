package co.gov.archivo.indicadores.services.helper;

import java.util.List;
import java.util.stream.Collectors;

import co.gov.archivo.indicadores.dtos.UserDto;
import co.gov.archivo.indicadores.entities.Usuario;

public class UsuarioHelper {
	
	public static UserDto getUsuarioDTO(Usuario entity){
		return UserDto.builder()
				.id(entity.getId())				
				.userName(entity.getUsername())				
				.password(entity.getPassword())		
				.lastAccess(entity.getUltimoAcceso()).build();
	}
	
	public static List<UserDto> toDTO(List<Usuario> entities) {
        return entities.stream().map(UsuarioHelper::getUsuarioDTO).collect(Collectors.toList());
    }
}

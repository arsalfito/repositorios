package co.gov.archivo.indicadores.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDTO {
	private Long idUser;    
    private String password; 
}

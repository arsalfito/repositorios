package co.gov.archivo.indicadores.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.gov.archivo.indicadores.common.ResponseHandler;
import co.gov.archivo.indicadores.dtos.UserDto;
import co.gov.archivo.indicadores.services.AuthService;
import co.gov.archivo.indicadores.services.UsuarioService;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class Test {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/listar")
	public ResponseEntity<?> listar() {		
		System.out.println("hola mundo!");		
		UserDto user = new UserDto();
		return ResponseHandler.generateResponse("Usuario creado correctamente", HttpStatus.OK, user);
	}

}

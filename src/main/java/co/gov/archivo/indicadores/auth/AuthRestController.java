package co.gov.archivo.indicadores.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.gov.archivo.indicadores.common.ResponseHandler;
import co.gov.archivo.indicadores.dtos.LoginDto;
import co.gov.archivo.indicadores.dtos.UserDto;
import co.gov.archivo.indicadores.services.AuthService;
import co.gov.archivo.indicadores.services.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

  @Autowired
  AuthService authService;
  
  @Autowired
  private UsuarioService usuarioService;
  
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginDto user) {
	  try {
		  Object data = authService.login(user);
		  if (data.equals(400))
			  return ResponseHandler.generateResponse("Usuario bloqueado", HttpStatus.UNAUTHORIZED, null);
		  else if (data.equals(401))
			  return ResponseHandler.generateResponse("Usuario inactivo", HttpStatus.UNAUTHORIZED, null);
		  else if (data.equals(402))
			  return ResponseHandler.generateResponse("El usuario ya tiene una sesión activa en el sistema.", HttpStatus.UNAUTHORIZED, null);
		  else if (data.equals(403))
		      return ResponseHandler.generateResponse("Usuario no autorizado", HttpStatus.UNAUTHORIZED, null);
		  return ResponseHandler.generateResponse("Ingreso correcto", HttpStatus.OK, data);
		}catch(Exception e) {			
			return ResponseHandler.generateResponse("Error al autenticar el usuario: " + e.getMessage(), HttpStatus.CONFLICT, null);
		}
  }
  
  @GetMapping("logout/{idUser}")
  public ResponseEntity<?> logout(@PathVariable("idUser") Long idUser){
		try {
			Object data = usuarioService.logout(idUser);
			if(data.equals(404))
				return ResponseHandler.generateResponse("Usuario no registrado en el sistema.",HttpStatus.NOT_FOUND, null);
			return ResponseHandler.generateResponse("La sesión fue cerrada satisfactoriamente!", HttpStatus.OK, true);
		}catch(Exception e) {			
			return ResponseHandler.generateResponse("Error al actualizar la contrseña: " + e.getMessage(), 
					HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
  }
  
  @GetMapping("/applications/{userName}")
  public ResponseEntity<?> getAppUser(@PathVariable String userName) {
	  /*try {
		  Object data = authService.findApplicationsUser(userName);
		    if (data.equals(404)){
		      return ResponseHandler.generateResponse("El usuario no tiene aplicaciones registradas.", HttpStatus.NOT_FOUND, null);
		    }
		    return ResponseHandler.generateResponse("Aplicaciones de usuario", HttpStatus.OK, data);
		}catch(Exception e) {
			return ResponseHandler.generateResponse("Error al consultar las aplicaciones del usuario: " + e.getMessage(), HttpStatus.CONFLICT, null);
		}*/
	  return null;
  }
  
  @PostMapping()
  public ResponseEntity<?> register(@RequestBody UserDto user)  {	  
    Object data = authService.registerUser(user);
    if(data.equals(409)) {
      return ResponseHandler.generateResponse("El username ya existe", HttpStatus.CONFLICT, data);
    }
    return ResponseHandler.generateResponse("Usuario creado correctamente", HttpStatus.OK, data);
  }
}

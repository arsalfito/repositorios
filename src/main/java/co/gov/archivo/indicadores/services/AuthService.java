package co.gov.archivo.indicadores.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.gov.archivo.indicadores.dtos.LoginDto;
import co.gov.archivo.indicadores.dtos.UserDto;
import co.gov.archivo.indicadores.entities.Usuario;
import co.gov.archivo.indicadores.repositories.UsuarioRepository;
import co.gov.archivo.indicadores.security.JwtService;

@Service
public class AuthService {

  @Autowired
  UsuarioRepository usuarioRepository;
  
  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  JwtService jwtService;
  
  public Object login(LoginDto user) {	
	 return null;
  }
  
  
  
  public Object registerUser(UserDto user) {
	    /*if(userRepository.existsByUsername(user.getUsername())) {
	      return 409;
	    }
	    
	    User userNew = User.builder()
	        .name(user.getName())
	        .lastName(user.getLastName())
	        .username(user.getUsername())
	        .password(passwordEncoder.encode(user.getPassword()))
	        .active(true)
	        .createdAt(new Date())
	        .build();
	    return userRepository.save(userNew);*/
	    return null;
  }
	  
  
  public Usuario loadUserByUsername(String username) {
    return usuarioRepository.findByUserName(username).get();
  }
  
 
  
  
}

package co.gov.archivo.indicadores.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.gov.archivo.indicadores.dtos.UserDto;
import co.gov.archivo.indicadores.entities.Usuario;
import co.gov.archivo.indicadores.repositories.UsuarioRepository;
import co.gov.archivo.indicadores.services.helper.UsuarioHelper;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
		
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Object logout(Long idUser) {
		Optional<Usuario> optUsuario = usuarioRepository.findById(idUser);
		if (optUsuario.isPresent()) {
			Usuario usuario = optUsuario.get();
			usuario.setEstadoLogin(false);
			usuarioRepository.save(usuario);
			return 200;
		}else
			return 404;		
	}
	
	public Usuario loadUserByUsername(String username) {
	    return usuarioRepository.findByUserName(username).get();
	}
	
	public Optional<Usuario> obtenerUsuarioPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	@Transactional
	public Usuario actualizarUsuario(Long id, Usuario usuario) {
		if (!usuarioRepository.existsById(id)) {
			throw new RuntimeException("Usuario no encontrado");
		}
		usuario.setId(id);
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public List<UserDto> listarUsuarios(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		return UsuarioHelper.toDTO(usuarios);
	}
	
}

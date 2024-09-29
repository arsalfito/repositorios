package co.gov.archivo.indicadores.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.gov.archivo.indicadores.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Boolean existsByUserName(String userName);
	
	Optional<Usuario> findByUserName(String userName);
	
	List<Usuario> findAll();
	
		                  
}

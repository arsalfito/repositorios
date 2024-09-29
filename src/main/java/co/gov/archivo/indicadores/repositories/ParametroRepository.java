package co.gov.archivo.indicadores.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.gov.archivo.indicadores.entities.Parametro;

public interface ParametroRepository extends JpaRepository<Parametro, Long> {

	@Query("SELECT p FROM Parametro p WHERE p.parametro = :parametro")
	public Optional<List<Parametro>> findByTipoParametroId(Long parametro);
	
	@Query("SELECT p FROM Parametro p WHERE p.parametro = :parametro AND p.idEntidad = :idEntidad")
	public Optional<Parametro> findByTipoParametroIdAndIdEntidad(Long parametro, Long idEntidad);
	
	@Query("SELECT p FROM Parametro p WHERE p.parametro = :parametro AND p.parent = :parent")
	public Optional<List<Parametro>> findParametroByParametroAndParent(Long parametro, Long parent);
}

package co.gov.archivo.indicadores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.gov.archivo.indicadores.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

	Boolean existsByDocumento(String documento);
}

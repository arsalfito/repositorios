package co.gov.archivo.indicadores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.gov.archivo.indicadores.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	

}

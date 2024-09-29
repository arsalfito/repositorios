package co.gov.archivo.indicadores.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.gov.archivo.indicadores.dtos.ParamDto;
import co.gov.archivo.indicadores.entities.Parametro;
import co.gov.archivo.indicadores.exceptions.AuthUsuarioException;
import co.gov.archivo.indicadores.repositories.ParametroRepository;

@Service
public class ParametroService {

	@Autowired
	private ParametroRepository parametroRepository; 
	
	public List<ParamDto> findParametro(Long parametro){
		List<Parametro> result = parametroRepository.findByTipoParametroId(parametro)
				.orElseThrow(() -> new AuthUsuarioException("El parámetro no está registrado."));
		return result.stream().map(par -> new ParamDto(
				par.getIdEntidad(),
				par.getDescripcion(),
				par.getParametro(),
				par.getParent() != null ? par.getParent() : null, 
				par.getValue()))
	                .collect(Collectors.toList());		
	}
	
	public List<ParamDto> findParametroByParametroAndParent(Long parametro, Long parent){
		List<Parametro> result = parametroRepository.findParametroByParametroAndParent(parametro, parent)
				.orElseThrow(() -> new AuthUsuarioException("El parámetro no está registrado."));
		
		return result.stream().map(par -> new ParamDto(
				par.getIdEntidad(),
				par.getDescripcion(),
				par.getParametro(),
				par.getParent() != null ? par.getParent() : null, 
				par.getValue()))
	                .collect(Collectors.toList());
	}
}

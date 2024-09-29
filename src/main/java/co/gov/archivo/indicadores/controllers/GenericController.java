package co.gov.archivo.indicadores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.gov.archivo.indicadores.dtos.ParamDto;
import co.gov.archivo.indicadores.services.ParametroService;

@RestController
@RequestMapping("/parameter")
@CrossOrigin(origins = "*")
public class GenericController {
	
	@Autowired
	private ParametroService parametroService;

	@GetMapping
	public ResponseEntity<?> findByEntityAndProperty(@RequestParam Long parameter) {
		try {
            List<ParamDto> entity = parametroService.findParametro(parameter);
            return ResponseEntity.ok(entity);
        } catch (IllegalArgumentException e) {        	
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
	}
	
}

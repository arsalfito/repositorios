package co.gov.archivo.indicadores.exceptions;

public class AuthUsuarioException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public AuthUsuarioException(String mensaje) {
        super(mensaje);
    }

}

package com.todo1.hulkstore.exceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/***
 * RestResponseEntityExceptionHandler encargada de manejar los errores en los controllers y transformarlos a excepciones Http
 * Mapea la excepciones de negocio a capa de presentación
 * @author marfernandez
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<?> exception(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>("Ha sucedido un error con su request", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler({ InventarioInsuficienteException.class })
	public ResponseEntity<?> inventarioInsuficienteException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler({ InventarioNotFoundException.class })
	public ResponseEntity<?> inventarioNotFoundException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ KardexNotFoundException.class })
	public ResponseEntity<?> kardexNotFoundException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ ProductoNotFoundException.class })
	public ResponseEntity<?> productoNotFoundException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ TipoOperacionNotFoundException.class })
	public ResponseEntity<?> tipoOperacionNotFoundException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ TipoSuperheroeNotFoundException.class })
	public ResponseEntity<?> tipoSuperheroeNotFoundException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ CantidadInvalidaException.class })
	public ResponseEntity<?> cantidadInvalidaException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ ValorInvalidoException.class })
	public ResponseEntity<?> valorInvalidoException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ ProductoExistenteException.class })
	public ResponseEntity<?> productoExistenteException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ CompraVentaProductoDtoInvalidException.class })
	public ResponseEntity<?> compraVentaProductoDtoInvalidException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
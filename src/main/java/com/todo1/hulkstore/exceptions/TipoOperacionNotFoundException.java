package com.todo1.hulkstore.exceptions;

import com.todo1.hulkstore.model.TipoOperacion.Operacion;

/**
 * TipoOperacionNotFoundException CustomException
 * @author mariano
 *
 */
public class TipoOperacionNotFoundException  extends CustomException {
	private static final long serialVersionUID = -181372725865515242L;

	public TipoOperacionNotFoundException(long id) {
		super(String.format("TipoOperacion no encontrado: [%s] ",id));
	}

	public TipoOperacionNotFoundException(Operacion operacion) {
		super(String.format("TipoOperacion no encontrado: [%s] ",operacion));
	}

}

package com.todo1.hulkstore.exceptions;

/**
 * CantidadInvalidaException CustomException
 * @author mariano
 *
 */
public class CantidadInvalidaException  extends CustomException {
	private static final long serialVersionUID = 3325453395764420551L;

	public CantidadInvalidaException(long cantidad) {
		super(String.format("Cantidad inválida [%s]",cantidad));
	}


}

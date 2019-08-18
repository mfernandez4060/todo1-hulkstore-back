package com.todo1.hulkstore.exceptions;
/**
 * ValorInvalidoException CustomException
 * @author mariano
 *
 */
public class ValorInvalidoException  extends CustomException {
	private static final long serialVersionUID = 3325453395764420551L;

	public ValorInvalidoException(double valor) {
		super(String.format("Valor inválido [%s]",valor));
	}


}

package com.todo1.hulkstore.exceptions;
/**
 * TipoSuperheroeNotFoundException CustomException
 * @author mariano
 *
 */
public class TipoSuperheroeNotFoundException extends CustomException {
	private static final long serialVersionUID = -7487307530615419125L;

	public TipoSuperheroeNotFoundException(long id) {
		super(String.format("TipoSuperheroe no encontrado: [%s] ", id));
	}

}

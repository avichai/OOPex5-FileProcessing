package oop.ex5.filters;

import oop.ex5.parsing.BadParametersException;

/**
 * class represent a bad parameters value exception.(i.e. invalid value or illegel value.)
 * 
 * @author Avichai
 *
 */
public class BadValueParametersException extends BadParametersException {

	private static final String BAD_PARAMETERS_VALUE_EXCEPTION = "\nbad parameters value exception";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + BAD_PARAMETERS_VALUE_EXCEPTION;
	}
}

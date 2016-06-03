package oop.ex5.filters;

/**
 * class represent an invalid value exception.
 * 
 * @author Avichai
 *
 */
public class InvalidValueException extends BadValueParametersException {

	private static final String INVALID_VALUE = "\ninvalid value";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + INVALID_VALUE;
	}
}

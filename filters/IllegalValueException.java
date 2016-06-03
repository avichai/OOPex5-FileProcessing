package oop.ex5.filters;

/**
 * class represent an illegal value exception.
 * @author Avichai
 *
 */
public class IllegalValueException extends BadValueParametersException{

	private static final String ILLEGAL_VALUE = "\nillegal value";
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return super.toString() + ILLEGAL_VALUE;
	}
}

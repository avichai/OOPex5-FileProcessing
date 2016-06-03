package oop.ex5.parsing;




/**
 * This class represent a bad property parameters exception. (i.e. too many or
 * less then enough parameters)
 * 
 * @author Avichai
 *
 */
public class BadPropertyParametersException extends BadParametersException {

	private static final String BAD_PROPERTY_PARAMETERS_EXCEPTION = "\nbad property parameters exception";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + BAD_PROPERTY_PARAMETERS_EXCEPTION;
	}

}

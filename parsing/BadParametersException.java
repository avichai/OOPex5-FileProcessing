package oop.ex5.parsing;

import oop.ex5.filescript.NonCriticalException;


/**
 * class represent a bad parameters inputs exception.
 * 
 * @author Avichai
 *
 */
public class BadParametersException extends NonCriticalException {

	private static final String BAD_PARAMETERS = "\nBad parameters";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + BAD_PARAMETERS;
	}
}

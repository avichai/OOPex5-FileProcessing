package oop.ex5.parsing;

import oop.ex5.filescript.NonCriticalException;

/**
 * class represent a bad name exception (FILTER/ORDER sub section not correct).
 * 
 * @author Avichai
 *
 */
public class BadNameException extends NonCriticalException {

	private static final String BAD_NAME_FOR_SUB_SECTION = "\nBad name for sub-Section";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + BAD_NAME_FOR_SUB_SECTION;
	}
}

package oop.ex5.parsing;

import oop.ex5.filescript.CriticalException;

/**
 * This class represent a bad subsection exception.
 * 
 * @author Avichai
 *
 */
public class BadSubSectionException extends CriticalException {

	private static final String BAD_SUBSECTION_EXCEPTION = "\nbad subsection exception";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + BAD_SUBSECTION_EXCEPTION;
	}
}

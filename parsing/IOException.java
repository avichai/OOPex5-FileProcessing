package oop.ex5.parsing;

import oop.ex5.filescript.CriticalException;

/**
 * This class represent an IO exception(i.e. problems in accessing a file).
 * 
 * @author Avichai
 *
 */
public class IOException extends CriticalException {

	private static final String IO_EXCEPTION = "\n IO exception";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + IO_EXCEPTION;
	}
}

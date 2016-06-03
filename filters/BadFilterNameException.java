package oop.ex5.filters;

import oop.ex5.parsing.BadNameException;

/**
 * This class represent invalid description of filter exception.
 * 
 * @author Avichai
 *
 */
public class BadFilterNameException extends BadNameException {

	private static final String INVALID_DESCRIPTION_OF_FILTER = "\ninvalid description of filter";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + INVALID_DESCRIPTION_OF_FILTER;
	}
}

package oop.ex5.orders;

import oop.ex5.parsing.BadNameException;

/**
 * This class represent invalid description of order exception.
 * 
 * @author Avichai
 *
 */
public class FalseOrderNameException extends BadNameException {

	private static final String INVALID_DESCRIPTION_OF_ORDER = "\ninvalid description of order";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + INVALID_DESCRIPTION_OF_ORDER;
	}
}

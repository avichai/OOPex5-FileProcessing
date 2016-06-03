package oop.ex5.parsing;

/**
 * This class represent a missing order subsection exception.
 * 
 * @author Avichai
 *
 */
public class MissingOrderSubSectionException extends BadSubSectionException {

	private static final String MISSING_ORDER_SUBSECTION = "\n missing order subsection";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + MISSING_ORDER_SUBSECTION;
	}
}

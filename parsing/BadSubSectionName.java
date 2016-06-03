package oop.ex5.parsing;

/**
 * This class represent a bad subsection Name exception(i.e. not FILTER or
 * ORDER).
 * 
 * @author Avichai
 *
 */
public class BadSubSectionName extends BadSubSectionException {

	private static final String BAD_SUBSECTION_NAME = "\nbad subsection name";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + BAD_SUBSECTION_NAME;
	}
}

package oop.ex5.filescript;

/**
 * class represent invalid usage exception(i.e. anything other than 2 program
 * arguments)
 * 
 * @author Avichai
 *
 */
public class InvalidUsageException extends CriticalException {

	private static final String INVALID_USAGE = "\nInvalidUsage";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + INVALID_USAGE;
	}
}

package oop.ex5.filescript;

/**
 * class represent a non critical exception(not must exit exception).
 * 
 * @author Avichai
 *
 */
public class NonCriticalException extends FileScriptException {

	private static final String Non_CRITICAL_EXCEPTION = "\nNon critical exception";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + Non_CRITICAL_EXCEPTION;
	}
}

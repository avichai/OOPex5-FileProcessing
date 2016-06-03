package oop.ex5.filescript;

/**
 * class represent a critical exception(must exit exception).
 * 
 * @author Avichai
 *
 */
public class CriticalException extends FileScriptException {

	private static final String CRITICAL_EXCEPTION = "\ncritical exception";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + CRITICAL_EXCEPTION;
	}
}

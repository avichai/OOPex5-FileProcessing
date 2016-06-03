package oop.ex5.filescript;

/**
 * class represent a fileScript exception.
 * 
 * @author Avichai
 *
 */
public class FileScriptException extends Exception {

	private static final String THIS_IS_A_FILESCRIPT_EXCEPTION = "\nthis is a filescript exception";
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString() + THIS_IS_A_FILESCRIPT_EXCEPTION;
	}
}

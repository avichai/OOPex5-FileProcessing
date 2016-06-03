package oop.ex5.filters;

import java.io.File;

/**
 * An abstract class for all filters that dill with strings when the filter.
 * 
 * @author Avichai
 *
 */
public abstract class StringFilter implements Filter {
	private String insertedString;

	/**
	 * Construct new StringFilter.
	 * 
	 * @param insertedString
	 *            a String to filter by it.
	 */
	public StringFilter(String insertedString) {
		this.insertedString = insertedString;
	}

	@Override
	public boolean isPassed(File f) {
		if (filter(f, this.insertedString)) {
			return true;
		}
		return false;
	}

	/**
	 * filter the file.
	 * 
	 * @param f
	 *            the file to filter.
	 * @param insertedString
	 *            the inserted string to the constructor to filter by it.
	 * @return true if the file passed the filter and false otherwise.
	 */
	abstract boolean filter(File f, String insertedString);

}

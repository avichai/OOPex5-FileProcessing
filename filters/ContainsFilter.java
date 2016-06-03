package oop.ex5.filters;

import java.io.File;

/**
 * Class for a filter that filter a file if it has the smae string in it's name
 * as the string of the filter.
 * 
 * @author Avichai
 *
 */
public class ContainsFilter extends StringFilter {

	/**
	 * construct new ContainsFilter.
	 * 
	 * @param stringToFind
	 *            the string to filter files by it.
	 */
	public ContainsFilter(String stringToFind) {
		super(stringToFind);
	}

	@Override
	boolean filter(File f, String insertedString) {
		return f.getName().contains(insertedString);
	}

}

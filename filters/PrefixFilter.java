package oop.ex5.filters;

import java.io.File;

/**
 * Class for a filter that filter a file if it has the smae prefix as the prefix
 * of the filter.
 * 
 * @author Avichai
 *
 */
public class PrefixFilter extends StringFilter {

	/**
	 * construct new PrefixFilter.
	 * @param prefixToFind
	 *            the prefix to filter files by it.
	 */
	public PrefixFilter(String prefixToFind) {
		super(prefixToFind);
	}

	@Override
	boolean filter(File f, String insertedString) {
		if (f.getName().startsWith(insertedString)) {
		}
		return f.getName().startsWith(insertedString);
	}

}

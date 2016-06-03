package oop.ex5.filters;

import java.io.File;

/**
 * Class for a filter that filter a file if it has the smae suffix as the suffix
 * of the filter.
 * 
 * @author Avichai
 *
 */
public class SuffixFilter extends StringFilter {

	/**
	 * construct new SuffixFilter.
	 * 
	 * @param suffixToFind
	 *            the suffix to filter files by it.
	 */
	public SuffixFilter(String suffixToFind) {
		super(suffixToFind);
	}

	@Override
	boolean filter(File f, String insertedString) {
		return f.getName().endsWith(insertedString);
	}

}

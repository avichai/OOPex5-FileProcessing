package oop.ex5.filters;

import java.io.File;

/**
 * An interFace for a Filter.
 * 
 * @author Avichai
 *
 */
public interface Filter {
	/**
	 * filter a file.
	 * 
	 * @param f
	 *            the file to filter.
	 * @return true if th file has passed the filter.
	 */
	public boolean isPassed(File f);
}

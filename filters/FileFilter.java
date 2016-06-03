package oop.ex5.filters;

import java.io.File;

/**
 * Class for a filter that filter a file if it has the smae name as the name
 * inside the filter.
 * 
 * @author Avichai
 *
 */
public class FileFilter extends StringFilter {

	/**
	 * construct new FileFilter.
	 * 
	 * @param fileName
	 *            the fileName to filter files by it.
	 */
	public FileFilter(String fileName) {
		super(fileName);
	}

	@Override
	boolean filter(File f, String insertedString) {
		return f.getName().equals(insertedString);
	}

}

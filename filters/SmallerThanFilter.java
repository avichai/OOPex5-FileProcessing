package oop.ex5.filters;

import java.io.File;

/**
 * A class for a filter that filter files if their size is smaller than the size
 * that the filter filter by it.
 * 
 * @author Avichai
 *
 */
public class SmallerThanFilter implements Filter {
	private double size;

	/**
	 * construct new SmallerThanFilter.
	 * 
	 * @param size
	 *            the size that the filter filter by it.
	 */
	public SmallerThanFilter(double size) {
		this.size = size;
	}

	@Override
	public boolean isPassed(File f) {
		if (f.length() < this.size * Constant.TO_BYTES) {
			return true;
		}
		return false;
	}

}

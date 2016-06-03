package oop.ex5.filters;

import java.io.File;

/**
 * A filter that filter all the files that the filter it holds won't filter.
 * 
 * @author Avichai
 *
 */
public class NotFilter implements Filter {
	private Filter filter;

	/**
	 * construct new NotFilter.
	 * 
	 * @param filter
	 *            the filter that filter all the files we don't want to filter.
	 */
	public NotFilter(Filter filter) {
		this.filter = filter;
	}

	@Override
	public boolean isPassed(File f) {
		return !this.filter.isPassed(f);
	}

}

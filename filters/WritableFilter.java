package oop.ex5.filters;

import java.io.File;

/**
 * Class for a filter that filter a file if it's writable.
 * 
 * @author Avichai
 *
 */
public class WritableFilter extends YesNoFilters {

	/**
	 * construct new WritableFilter.
	 * 
	 * @param yesOrNo
	 *            YES if we want to filter writable files an NO otherwise.
	 */
	public WritableFilter(String yesOrNo) {
		super(yesOrNo);
	}

	@Override
	boolean checkSomethingOnFile(File f) {
		return f.canWrite();
	}

}

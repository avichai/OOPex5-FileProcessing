package oop.ex5.filters;

import java.io.File;

/**
 * A class for filter that filter a file if it's a hidden file or not.
 * 
 * @author Avichai
 *
 */
public class HiddenFilter extends YesNoFilters {

	/**
	 * construct new HiddenFilter.
	 * 
	 * @param yesOrNo
	 *            YES if we want the filter to filter hidden filer and NO
	 *            otherwise.
	 */
	public HiddenFilter(String yesOrNo) {
		super(yesOrNo);
	}

	@Override
	boolean checkSomethingOnFile(File f) {
		return f.isHidden();
	}

}

package oop.ex5.filters;

import java.io.File;

/**
 * An abstract class for Filters that can have "yes"/"no" command inside them.
 * 
 * @author Avichai
 *
 */
public abstract class YesNoFilters implements Filter {
	private static final String NO = "NO";
	private static final String YES = "YES";
	private String yesOrNo;

	/**
	 * constructor for new yes/no filter.
	 * 
	 * @param yesOrNo
	 *            YES if we want to filter by that filter files an NO otherwise.
	 */
	public YesNoFilters(String yesOrNo) {
		this.yesOrNo = yesOrNo;
	}

	@Override
	public boolean isPassed(File f) {
		if (checkSomethingOnFile(f)) {
			if (this.yesOrNo.equals(YES)) {
				return true;
			}
		} else {
			if (this.yesOrNo.equals(NO)) {
				return true;
			}
		}
		return false;
	}

	abstract boolean checkSomethingOnFile(File f);

}

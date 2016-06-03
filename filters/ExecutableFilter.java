package oop.ex5.filters;

import java.io.File;

/**
 * Class for a filter that filter a file if it's executable.
 * 
 * @author Avichai
 *
 */
public class ExecutableFilter extends YesNoFilters {

	/**
	 * construct new ExecutableFilter.
	 * 
	 * @param yesOrNo
	 *            YES if we want to filter executable files an NO otherwise.
	 */
	public ExecutableFilter(String yesOrNo) {
		super(yesOrNo);
	}

	@Override
	boolean checkSomethingOnFile(File f) {
		return f.canExecute();
	}

}

package oop.ex5.filters;

import java.io.File;

/**
 * A class for between filter that filter files by their size.
 * filter a file if it's size is between the upper vlue and the lower value of the filter.
 * @author Avichai
 *
 */
public class BetweenFilter implements Filter {
	
	private double lowSize;
	private double highSize;
	
	/**
	 * Construct new between filter.
	 * @param lowSize the lower bound of the filter.
	 * @param highSize the upper bound of the filter.
	 */
	public BetweenFilter(double lowSize, double highSize) {
		this.lowSize = lowSize;
		this.highSize = highSize;
	}

	@Override
	public boolean isPassed(File f) {
		if(f.length() <= this.highSize*Constant.TO_BYTES && f.length() >= this.lowSize*1024){
			return true;
		}
		return false;
	}

}

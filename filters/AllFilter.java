package oop.ex5.filters;

import java.io.File;

/**
 * A filter that filter all the files (i.e every file is passed).
 * 
 * @author Avichai
 *
 */
public class AllFilter implements Filter {

	@Override
	public boolean isPassed(File f) {
		return true;
	}

}

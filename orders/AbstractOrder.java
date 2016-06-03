package oop.ex5.orders;

import java.io.File;
import java.util.Comparator;
import java.util.TreeSet;


/**
 * An abstract class for order.
 * 
 * @author Avichai
 *
 */
public abstract class AbstractOrder implements Order {

	@Override
	public void getOrder(File[] filesToPrint) {

		if (filesToPrint != null) {
			TreeSet<File> sortedTreeSet = new TreeSet<File>(getComperator());
			for(File file : filesToPrint){
				sortedTreeSet.add(file);
			}
			sortedTreeSet.toArray(filesToPrint);
//			Arrays.sort(filesToPrint, getComperator());
		}
	}

	/**
	 * 
	 * @return a compartor of files.
	 */
	abstract Comparator<File> getComperator();

}

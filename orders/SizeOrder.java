package oop.ex5.orders;

import java.io.File;
import java.util.Comparator;

/**
 * A class for a order instance the sort files by size.
 * 
 * @author Avichai
 *
 */
public class SizeOrder extends AbstractOrder {

	@Override
	Comparator<File> getComperator() {
		return new Comparator<File>() {

			@Override
			public int compare(File o1, File o2) {
				if (o1.length() < o2.length()) {
					return Constant.SMALLER_THAN;
				} else if (o1.length() > o2.length()) {
					return Constant.GREATED_THAN;
				} else {
					return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
				}
			}
		};
	}

}

package oop.ex5.orders;

import java.io.File;
import java.util.Comparator;

/**
 * A class for abs order.
 * 
 * @author Avichai
 *
 */
public class AbsOrder extends AbstractOrder {

	@Override
	Comparator<File> getComperator() {
		return new Comparator<File>() {

			@Override
			public int compare(File o1, File o2) {
				return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
			}
		};
	}

}

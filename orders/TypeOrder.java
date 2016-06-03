package oop.ex5.orders;

import java.io.File;
import java.util.Comparator;

/**
 * A class for a order instance the sort files by type.
 * 
 * @author Avichai
 *
 */
public class TypeOrder extends AbstractOrder {

	private static final String DOT = ".";
	private static final int EQUAL_TO = 0;

	@Override
	Comparator<File> getComperator() {
		return new Comparator<File>() {

			@Override
			public int compare(File o1, File o2) {
				String filetype1 = o1.getName();
				String filetype2 = o2.getName();
				int pos1 = filetype1.lastIndexOf(DOT);
				int pos2 = filetype2.lastIndexOf(DOT);
				filetype1 = filetype1.substring(pos1, filetype1.length());
				filetype2 = filetype2.substring(pos2, filetype2.length());

				if (filetype1.compareTo(filetype2) < EQUAL_TO) {
					return Constant.SMALLER_THAN;
				} else if (filetype1.compareTo(filetype2) > EQUAL_TO) {
					return Constant.GREATED_THAN;
				} else {
					return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
				}
			}
		};
	}

}

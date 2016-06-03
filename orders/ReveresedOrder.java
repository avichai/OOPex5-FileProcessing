package oop.ex5.orders;

import java.io.File;
import java.util.ArrayList;

/**
 * A class for reverse order of some order type.
 * 
 * @author Avichai
 *
 */
public class ReveresedOrder implements Order {

	Order order;

	/**
	 * Constructor for reverse order.
	 * 
	 * @param order
	 */
	public ReveresedOrder(Order order) {
		this.order = order;
	}

	@Override
	public void getOrder(File[] filesToPrint) {
		if (filesToPrint != null) {
			this.order.getOrder(filesToPrint);
			ArrayList<File> reveresedFiles = reverse(filesToPrint);
			reveresedFiles.toArray(filesToPrint);
			
		}
	}

	/**
	 * reverse the order of the given file arrylist.
	 * 
	 * @param filesToPrint
	 *            arrylist of files.
	 * @return a reversed arry of files.
	 */
	private ArrayList<File> reverse(File[] filesToPrint) {
		if (filesToPrint != null) {
			ArrayList<File> reversedList = new ArrayList<File>();
			int i = filesToPrint.length-1;
			while (i!=-1) {
				reversedList.add(filesToPrint[i]);
				i--;
			}
			return reversedList;
		}
		return null;
	}
}

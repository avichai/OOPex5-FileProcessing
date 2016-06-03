package oop.ex5.orders;

import java.io.File;

/**
 * An interface of an order.
 * 
 * @author Avichai
 *
 */
public interface Order {
	/**
	 * sort tge files that were given in a certain order.
	 * 
	 * @param arrayOfFilesToPrint
	 *            the files to sort.
	 */
	public void getOrder(File[] arrayOfFilesToPrint);
}

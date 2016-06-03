package oop.ex5.orders;

import oop.ex5.parsing.BadPropertyParametersException;

/**
 * this class creates an order according to a line description.
 * 
 * @author Avichai
 *
 */
public class OrderFactory {
	private static final String REVERSE = "REVERSE";
	private static final String NOT_SIZE = "notSize";
	private static final String NOT_TYPE = "notType";
	private static final String NOT_ABS = "notAbs";
	private static final String SIZE = "size";
	private static final String TYPE = "type";
	private static final String ABS = "abs";
	private static final String HASH = "#";
	
	/*
	 * do'nt want to be able to create instance of this. 
	 */
	private OrderFactory(){
		
	}
	/**
	 * creates an order according to a line description.
	 * 
	 * @param lineDescription
	 *            a line description for an order.
	 * @return an Order instance.
	 * @throws FalseOrderNameException
	 *             bad description of order exception.
	 * @throws BadPropertyParametersException
	 *             bad number of parameters exception.
	 */
	public static Order createOrder(String lineDescription)
			throws FalseOrderNameException, BadPropertyParametersException {
		if (lineDescription == null) {
			return null;
		}
		String[] differentComands = lineDescription.split(HASH);
		if (lineDescription.startsWith(ABS)) {
			return dealWithAbs(differentComands);
		} else if (lineDescription.startsWith(TYPE)) {
			return dealWithType(differentComands);
		} else if (lineDescription.startsWith(SIZE)) {
			return dealWithSize(differentComands);
		} else {
			throw new FalseOrderNameException();
		}
	}

	/*
	 * Deal with abs order request.
	 * 
	 * @param differentComands the parsing of the abs order request.
	 * 
	 * @return an Order instance.
	 * 
	 * @throws FalseOrderNameException bad description of order exception.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 */
	private static Order dealWithAbs(String[] differentComands)
			throws FalseOrderNameException, BadPropertyParametersException {
		isSizeOfInputMatches(2, ABS, differentComands);
		return dealWithDiffOrders(2, NOT_ABS, ABS, differentComands);
	}

	/*
	 * Deal with type order request.
	 * 
	 * @param differentComands the parsing of the type order request.
	 * 
	 * @return an Order instance.
	 * 
	 * @throws FalseOrderNameException bad description of order exception.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 */
	private static Order dealWithType(String[] differentComands)
			throws FalseOrderNameException, BadPropertyParametersException {
		isSizeOfInputMatches(2, TYPE, differentComands);
		return dealWithDiffOrders(2, NOT_TYPE, TYPE, differentComands);
	}

	/*
	 * Deal with size order request.
	 * 
	 * @param differentComands the parsing of the size order request.
	 * 
	 * @return an Order instance.
	 * 
	 * @throws FalseOrderNameException bad description of order exception.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 */
	private static Order dealWithSize(String[] differentComands)
			throws FalseOrderNameException, BadPropertyParametersException {
		isSizeOfInputMatches(2, SIZE, differentComands);
		return dealWithDiffOrders(2, NOT_SIZE, SIZE, differentComands);
	}

	/*
	 * checking if the command line parsing is valid.
	 * 
	 * @param maxNumParamWithREV number of parameters that could be with REVERES
	 * command.
	 * 
	 * @param stringOrder the string represent the requested order.
	 * 
	 * @param differentComands the parsing of the abs order request.
	 * 
	 * @throws FalseOrderNameException bad description of order exception.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 */
	private static void isSizeOfInputMatches(int maxNumParamWithREV,
			String stringOrder, String[] differentComands)
			throws FalseOrderNameException, BadPropertyParametersException {
		if (differentComands.length > maxNumParamWithREV
				|| differentComands.length < maxNumParamWithREV - 1
				|| !differentComands[0].equals(stringOrder)) {
			if (differentComands.length > maxNumParamWithREV
					|| differentComands.length < maxNumParamWithREV - 1) {
				throw new BadPropertyParametersException();
			} else {
				throw new FalseOrderNameException();
			}
		}
	}

	/*
	 * help method to create the Order to return.
	 * 
	 * @param maxNumParamWithREV number of parameters that could be with REVERES
	 * command.
	 * 
	 * @param counterOrderClass a string for reverese order of the requested
	 * order.
	 * 
	 * @param orderClass a string for requested order.
	 * 
	 * @param differentComands the parsing of the abs order request.
	 * 
	 * @return an Order instance.
	 * 
	 * @throws FalseOrderNameException bad description of order exception.
	 */
	private static Order dealWithDiffOrders(int maxNumParamWithREV,
			String counterOrderClass, String orderClass,
			String[] differentComands) throws FalseOrderNameException {
		if (differentComands.length == maxNumParamWithREV) {
			if (differentComands[maxNumParamWithREV - 1].equals(REVERSE)) {
				return createNewStringFilter(counterOrderClass);
			} else {
				throw new FalseOrderNameException();
			}
		} else {
			return createNewStringFilter(orderClass);
		}
	}

	/**
	 * help method to create the Order to return.
	 * 
	 * @param orderClass
	 *            a string for requested order.
	 * @return an Order instance.
	 * @throws FalseOrderNameException
	 *             bad description of order exception.
	 */
	private static Order createNewStringFilter(String orderClass)
			throws FalseOrderNameException {
		if (orderClass.equals(ABS)) {
			return new AbsOrder();
		} else if (orderClass.equals(NOT_ABS)) {
			return new ReveresedOrder(new AbsOrder());
		} else if (orderClass.equals(TYPE)) {
			return new TypeOrder();
		} else if (orderClass.equals(NOT_TYPE)) {
			return new ReveresedOrder(new TypeOrder());
		} else if (orderClass.equals(SIZE)) {
			return new SizeOrder();
		} else if (orderClass.equals(NOT_SIZE)) {
			return new ReveresedOrder(new SizeOrder());
		}
		throw new FalseOrderNameException();
	}
	public static Order createDefaultOrder() {
		return new AbsOrder();
	}
}

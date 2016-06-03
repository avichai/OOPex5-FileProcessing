package oop.ex5.filters;

import oop.ex5.parsing.BadParametersException;
import oop.ex5.parsing.BadPropertyParametersException;

/**
 * this class creates a filter according to a line description.
 * 
 * @author Avichai
 *
 */
public class FilterFactory {

	private static final String NOT = "NOT";
	private static final String NO = "NO";
	private static final String YES = "YES";
	private static final String NOT_HIDDEN = "notHidden";
	private static final String NOT_EXECUTABLE = "notExecutable";
	private static final String NOT_WRITABLE = "notWritable";
	private static final String ALL_BUT_THAT_SUFFIX = "allButThatSuffix";
	private static final String ALL_WITHOUT_PREFIX = "allWithoutPrefix";
	private static final String DOES_NOT_CONTAINS = "doesNotContains";
	private static final String ALL_BUT_FILE = "allButFile";
	private static final String GREATER_OR_EQUAL_TO = "greaterOrEqualTo";
	private static final String GREATER_AND_SMALLER_THAN = "greaterAndSmallerThan";
	private static final String SMALLER_OR_EQUAL_TO = "smallerOrEqualTO";
	private static final String ALL = "all";
	private static final String HIDDEN = "hidden";
	private static final String EXECUTABLE = "executable";
	private static final String WRITABLE = "writable";
	private static final String SUFFIX = "suffix";
	private static final String PREFIX = "prefix";
	private static final String CONTAINS = "contains";
	private static final String FILE = "file";
	private static final String SMALLER_THAN = "smaller_than";
	private static final String BETWEEN = "between";
	private static final String GREATER_THAN = "greater_than";
	private static final String HASH = "#";
	
	/*
	 * do'nt want to be able to create instance of this. 
	 */
	private FilterFactory(){
		
	}
	/**
	 * creates a filter according to a line description.
	 * 
	 * @param lineDescription
	 *            a line description for a filter.
	 * @return a Filter instance.
	 * @throws BadFilterNameException
	 *             bad description of filter exception.
	 * @throws BadParametersException
	 *             bad parameters for filter.
	 */
	public static Filter createFilter(String lineDescription)
			throws BadFilterNameException, BadParametersException {
		if (lineDescription == null) {
			return null;
		}
		String[] differentComands = lineDescription.split(HASH);
		if (lineDescription.startsWith(GREATER_THAN)) {
			return dealWithGreaterThan(differentComands);
		} else if (lineDescription.startsWith(BETWEEN)) {
			return dealWithBetween(differentComands);
		} else if (lineDescription.startsWith(SMALLER_THAN)) {
			return dealWithSmallerThan(differentComands);
		} else if (lineDescription.startsWith(FILE)) {
			return dealWithFile(differentComands);
		} else if (lineDescription.startsWith(CONTAINS)) {
			return dealWithContains(differentComands);
		} else if (lineDescription.startsWith(PREFIX)) {
			return dealWitPrefix(differentComands);
		} else if (lineDescription.startsWith(SUFFIX)) {
			return dealWitSuffix(differentComands);
		} else if (lineDescription.startsWith(WRITABLE)) {
			return dealWitWritable(differentComands);
		} else if (lineDescription.startsWith(EXECUTABLE)) {
			return dealWitExecutable(differentComands);
		} else if (lineDescription.startsWith(HIDDEN)) {
			return dealWitHidden(differentComands);
		} else if (lineDescription.startsWith(ALL)) {
			return dealWitAll(differentComands);
		} else {
			throw new BadFilterNameException();
		}

	}

	/*
	 * Deal with greater than filter request.
	 * 
	 * @param differentComands the parsing of the greaterThen filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 * 
	 * @throws IllegalValueException illegal value for filter exception.
	 */
	private static Filter dealWithGreaterThan(String[] differentComands)
			throws BadPropertyParametersException, BadFilterNameException,
			InvalidValueException, IllegalValueException {
		isSizeOfInputMatches(3, GREATER_THAN, differentComands);
		return dealWithDoubleFilters(3, SMALLER_OR_EQUAL_TO, GREATER_THAN,
				differentComands);
	}

	/*
	 * Deal with between filter request.
	 * 
	 * @param differentComands the parsing of the between filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 * 
	 * @throws IllegalValueException illegal value for filter exception.
	 */
	private static Filter dealWithBetween(String[] differentComands)
			throws BadPropertyParametersException, BadFilterNameException,
			InvalidValueException, IllegalValueException {
		isSizeOfInputMatches(4, BETWEEN, differentComands);
		return dealWithDoubleFilters(4, GREATER_AND_SMALLER_THAN, BETWEEN,
				differentComands);
	}

	/*
	 * Deal with smaller than filter request.
	 * 
	 * @param differentComands the parsing of the smallerThan filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 * 
	 * @throws IllegalValueException illegal value for filter exception.
	 */
	private static Filter dealWithSmallerThan(String[] differentComands)
			throws BadPropertyParametersException, BadFilterNameException,
			InvalidValueException, IllegalValueException {
		isSizeOfInputMatches(3, SMALLER_THAN, differentComands);
		return dealWithDoubleFilters(3, GREATER_OR_EQUAL_TO, SMALLER_THAN,
				differentComands);
	}

	/*
	 * Deal with file filter request.
	 * 
	 * @param differentComands the parsing of the file filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 */
	private static Filter dealWithFile(String[] differentComands)
			throws BadPropertyParametersException, BadFilterNameException,
			InvalidValueException {
		isSizeOfInputMatches(3, FILE, differentComands);
		return dealWithStringFilters(3, ALL_BUT_FILE, FILE, differentComands,
				false);
	}

	/*
	 * Deal with contains filter request.
	 * 
	 * @param differentComands the parsing of the contains filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 */
	private static Filter dealWithContains(String[] differentComands)
			throws BadPropertyParametersException, BadFilterNameException,
			InvalidValueException {
		isSizeOfInputMatches(3, CONTAINS, differentComands);
		return dealWithStringFilters(3, DOES_NOT_CONTAINS, CONTAINS,
				differentComands, false);
	}

	/*
	 * Deal with prefix filter request.
	 * 
	 * @param differentComands the parsing of the prefix filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 */
	private static Filter dealWitPrefix(String[] differentComands)
			throws BadPropertyParametersException, BadFilterNameException,
			InvalidValueException {
		isSizeOfInputMatches(3, PREFIX, differentComands);
		return dealWithStringFilters(3, ALL_WITHOUT_PREFIX, PREFIX,
				differentComands, false);
	}

	/*
	 * Deal with suffix filter request.
	 * 
	 * @param differentComands the parsing of the suffix filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 */
	private static Filter dealWitSuffix(String[] differentComands)
			throws BadPropertyParametersException, BadFilterNameException,
			InvalidValueException {
		isSizeOfInputMatches(3, SUFFIX, differentComands);
		return dealWithStringFilters(3, ALL_BUT_THAT_SUFFIX, SUFFIX,
				differentComands, false);
	}

	/*
	 * Deal with writable filter request.
	 * 
	 * @param differentComands the parsing of the writable filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 */
	private static Filter dealWitWritable(String[] differentComands)
			throws BadPropertyParametersException, BadFilterNameException,
			InvalidValueException {
		isSizeOfInputMatches(3, WRITABLE, differentComands);
		return dealWithStringFilters(3, NOT_WRITABLE, WRITABLE,
				differentComands, true);
	}

	/*
	 * Deal with exectutable filter request.
	 * 
	 * @param differentComands the parsing of the exectutable filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 */
	private static Filter dealWitExecutable(String[] differentComands)
			throws BadPropertyParametersException, BadFilterNameException,
			InvalidValueException {
		isSizeOfInputMatches(3, EXECUTABLE, differentComands);
		return dealWithStringFilters(3, NOT_EXECUTABLE, EXECUTABLE,
				differentComands, true);
	}

	/*
	 * Deal with hidden filter request.
	 * 
	 * @param differentComands the parsing of the hidden filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 */
	private static Filter dealWitHidden(String[] differentComands)
			throws BadPropertyParametersException, BadFilterNameException,
			InvalidValueException {
		isSizeOfInputMatches(3, HIDDEN, differentComands);
		return dealWithStringFilters(3, NOT_HIDDEN, HIDDEN, differentComands,
				true);
	}

	/*
	 * Deal with all filter request.
	 * 
	 * @param differentComands the parsing of the all filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 */
	private static Filter dealWitAll(String[] differentComands)
			throws InvalidValueException, BadPropertyParametersException,
			BadFilterNameException {
		isSizeOfInputMatches(2, ALL, differentComands);

		if (differentComands.length == 1) {
			return new AllFilter();
		} else {
			if (!differentComands[1].equals("Not")) {
				throw new InvalidValueException();
			} else {
				return new NotFilter(new AllFilter());
			}
		}

	}

	/*
	 * checking if the command line parsing is valid.
	 * 
	 * @param maxNumParamWithREV number of parameters that could be with NOT
	 * command.
	 * 
	 * @param stringOrder the string represent the requested filter.
	 * 
	 * @param differentComands the parsing of the abs filter request.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws BadPropertyParametersException bad number of parameters
	 * exception.
	 */
	private static void isSizeOfInputMatches(int maxNumParamWithREV,
			String stringFilter, String[] differentComands)
			throws BadPropertyParametersException, BadFilterNameException {
		if (differentComands.length > maxNumParamWithREV
				|| differentComands.length < maxNumParamWithREV - 1
				|| !differentComands[0].equals(stringFilter)) {
			if (differentComands.length > maxNumParamWithREV
					|| differentComands.length < maxNumParamWithREV - 1) {
				throw new BadPropertyParametersException();
			} else {
				throw new BadFilterNameException();
			}
		}
	}

	/*
	 * Deal with creating filter that filter by a double.
	 * 
	 * @param maxNumParamWithREV number of parameters that could be with NOT
	 * command.
	 * 
	 * @param counterFilterClass a string of the counter filte.
	 * 
	 * @param filterClass a string of the filter.
	 * 
	 * @param differentComands the parsing of the abs filter request.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 * 
	 * @throws IllegalValueException illegal value for filter exception.
	 */
	private static Filter dealWithDoubleFilters(int maxNumParamWithREV,
			String counterFilterClass, String filterClass,
			String[] differentComands) throws InvalidValueException,
			IllegalValueException, BadFilterNameException {
		try {
			double size = Double.parseDouble(differentComands[1]);
			double highSize = -1;
			if (filterClass.equals(BETWEEN)) {
				highSize = Double.parseDouble(differentComands[2]);
				if (highSize < 0 || highSize < size) {
					throw new IllegalValueException();
				}
			}
			if (size < 0) {
				throw new IllegalValueException();
			}
			if (differentComands.length == maxNumParamWithREV) {
				if (differentComands[maxNumParamWithREV - 1].equals(NOT)) {
					if (filterClass.equals(BETWEEN)) {
						return new NotFilter(new BetweenFilter(size, highSize));
					} else {
						return createFilterWithDoubel(counterFilterClass, size);
					}
				} else {
					throw new InvalidValueException();
				}
			} else {
				if (filterClass.equals(BETWEEN)) {
					return new BetweenFilter(size, highSize);
				} else {
					return createFilterWithDoubel(filterClass, size);
				}
			}
		} catch (NumberFormatException e) {
			throw new IllegalValueException();
		}
	}

	/*
	 * Creates a new filter that filter by a double.
	 * 
	 * @param filterClass a string of the filter.
	 * 
	 * @param size the argument to sent to the constructor.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 */
	private static Filter createFilterWithDoubel(String filterClass, double size)
			throws BadFilterNameException {
		if (filterClass.equals(GREATER_THAN)) {
			return new GreaterThanFilter(size);
		} else if (filterClass.equals(SMALLER_OR_EQUAL_TO)) {
			return new NotFilter(new GreaterThanFilter(size));
		} else if (filterClass.equals(SMALLER_THAN)) {

			return new SmallerThanFilter(size);
		} else if (filterClass.equals(GREATER_OR_EQUAL_TO)) {
			return new NotFilter(new SmallerThanFilter(size));
		}
		throw new BadFilterNameException();
	}

	/*
	 * Deal with creating filter that filter by a string.
	 * 
	 * @param maxNumParamWithREV number of parameters that could be with NOT
	 * command.
	 * 
	 * @param counterFilterClass a string of the counter filte.
	 * 
	 * @param filterClass a string of the filte.
	 * 
	 * @param differentComands the parsing of the abs filter request.
	 * 
	 * @param isBooleanFilter true if the filter can have yes/no command and
	 * false otherwise.
	 * 
	 * @return a Filter instance.
	 * 
	 * @throws InvalidValueException invalid value for filter exception.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 */
	private static Filter dealWithStringFilters(int maxNumParamWithREV,
			String counterFilterClass, String filterClass,
			String[] differentComands, boolean isBooleanFilter)
			throws InvalidValueException, BadFilterNameException {
		String sentArgumentToFilter = differentComands[1];
		if (isBooleanFilter) {
			if (!sentArgumentToFilter.equals(NO)
					&& !sentArgumentToFilter.equals(YES)) {
				throw new InvalidValueException();
			}
		}
		if (differentComands.length == maxNumParamWithREV) {
			if (differentComands[maxNumParamWithREV - 1].equals(NOT)) {
				return createNewStringFilter(counterFilterClass,
						sentArgumentToFilter);
			} else {
				throw new InvalidValueException();
			}
		} else {
			return createNewStringFilter(filterClass, sentArgumentToFilter);
		}
	}

	/*
	 * Creates a new filter that filter by a string.
	 * 
	 * @param filterClass a string for requested filter.
	 * 
	 * @param sentArgumentToFilter the string to sent to the constructor of the
	 * filter.
	 * 
	 * @return a new filter.
	 * 
	 * @throws BadFilterNameException bad description of filter exception.
	 */
	private static Filter createNewStringFilter(String filterClass,
			String sentArgumentToFilter) throws BadFilterNameException {
		if (filterClass.equals(FILE)) {
			return new FileFilter(sentArgumentToFilter);
		} else if (filterClass.equals(ALL_BUT_FILE)) {
			return new NotFilter(new FileFilter(sentArgumentToFilter));
		} else if (filterClass.equals(CONTAINS)) {
			return new ContainsFilter(sentArgumentToFilter);
		} else if (filterClass.equals(DOES_NOT_CONTAINS)) {
			return new NotFilter(new ContainsFilter(sentArgumentToFilter));
		} else if (filterClass.equals(PREFIX)) {
			return new PrefixFilter(sentArgumentToFilter);
		} else if (filterClass.equals(ALL_WITHOUT_PREFIX)) {
			return new NotFilter(new PrefixFilter(sentArgumentToFilter));
		} else if (filterClass.equals(SUFFIX)) {
			return new SuffixFilter(sentArgumentToFilter);
		} else if (filterClass.equals(ALL_BUT_THAT_SUFFIX)) {
			return new NotFilter(new SuffixFilter(sentArgumentToFilter));
		} else if (filterClass.equals(WRITABLE)) {
			return new WritableFilter(sentArgumentToFilter);
		} else if (filterClass.equals(NOT_WRITABLE)) {
			if (sentArgumentToFilter.equals(YES)) {
				return new WritableFilter(NO);
			} else {
				return new WritableFilter(YES);
			}
		} else if (filterClass.equals(EXECUTABLE)) {
			return new ExecutableFilter(sentArgumentToFilter);
		} else if (filterClass.equals(NOT_EXECUTABLE)) {
			if (sentArgumentToFilter.equals(YES)) {
				return new ExecutableFilter(NO);
			} else {
				return new ExecutableFilter(YES);
			}
		} else if (filterClass.equals(HIDDEN)) {
			return new HiddenFilter(sentArgumentToFilter);
		} else if (filterClass.equals(NOT_HIDDEN)) {
			if (sentArgumentToFilter.equals(YES)) {
				return new HiddenFilter(NO);
			} else {
				return new HiddenFilter(YES);
			}
		}
		throw new BadFilterNameException();
	}
	/**
	 * 
	 * @return a difault filter.
	 */
	public static Filter createDefaultFilter() {
		return new AllFilter();
	}
}

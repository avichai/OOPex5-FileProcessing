package oop.ex5.parsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import oop.ex5.filters.BadFilterNameException;
import oop.ex5.filters.Filter;
import oop.ex5.filters.FilterFactory;
import oop.ex5.orders.FalseOrderNameException;
import oop.ex5.orders.Order;
import oop.ex5.orders.OrderFactory;
import oop.ex5.sections.Section;

/**
 * This class parse command file to sections.
 * 
 * @author Avichai
 *
 */
public class Parsing {

	/*
	 * do'nt want to be able to create instance of this.
	 */
	private Parsing() {

	}

	private static final String ORDER = "ORDER";
	private static final String FILTER = "FILTER";

	/**
	 * Create section from a given command file.
	 * 
	 * @param commandFilePath
	 *            the command file to pars.
	 * @return an araylist of sections.
	 * @throws oop.ex5.parsing.IOException
	 *             throw a critical exception.
	 * @throws BadSubSectionException
	 *             throw a critical exception.
	 */
	public static Section[] parseSection(String commandFilePath)
			throws oop.ex5.parsing.IOException, BadSubSectionException {
		File commandFile = new File(commandFilePath);
		if (!commandFile.exists()) {
			return null;
		}
		Section[] mySectionList = createSection(commandFile);
		return mySectionList;
	}

	/*
	 * help method for parseSection().
	 * 
	 * @param commandFile the command file to pars.
	 * 
	 * @return an araylist of sections.
	 * 
	 * @throws oop.ex5.parsing.IOException throw a critical exception.
	 * 
	 * @throws BadSubSectionException throw a critical exception.
	 */
	private static Section[] createSection(File commandFile)
			throws oop.ex5.parsing.IOException, BadSubSectionException {
		try {
			FileReader readFile = new FileReader(commandFile);
			try (BufferedReader br = new BufferedReader(readFile)) {
				ArrayList<Section> sections = new ArrayList<Section>();
				parseSections(br, sections);
				Section[] returnedSections = new Section[sections.size()];
				sections.toArray(returnedSections);
				return returnedSections;
			} catch (IOException e) {
				throw new oop.ex5.parsing.IOException();
			}
		} catch (FileNotFoundException e) {
			throw new oop.ex5.parsing.IOException();
		}

	}

	/*
	 * help method for createSection().
	 * 
	 * @param br a BufferedReader of the command file.
	 * 
	 * @param sections an arraylist of sections.
	 * 
	 * @throws BadSubSectionException throw a critical exception.
	 * 
	 * @throws IOException throw a critical exception.
	 */
	private static void parseSections(BufferedReader br,
			ArrayList<Section> sections) throws BadSubSectionException,
			IOException {
		String line = br.readLine();
		while (line != null) {
			Filter filter;
			Order order;
			boolean sectionWithOrderLine = true;
			boolean filterWarning = false;
			boolean orderWarning = false;
			if (line.equals(FILTER)) {
				try {
					filter = FilterFactory.createFilter(br.readLine());
				} catch (BadFilterNameException | BadParametersException e) {
					filter = FilterFactory.createDefaultFilter();
					filterWarning = true;
				}
				line = br.readLine();
				if (line == null || !line.equals(ORDER)) {
					throw new MissingOrderSubSectionException();
				} else {
					line = br.readLine();
					if (line != null && !line.equals(FILTER)) {
						try {
							order = OrderFactory.createOrder(line);
						} catch (FalseOrderNameException
								| BadPropertyParametersException e) {
							order = OrderFactory.createDefaultOrder();
							orderWarning = true;
						}
						line = br.readLine();
					} else {
						order = OrderFactory.createDefaultOrder();
						sectionWithOrderLine = false;
					}
				}

			} else {
				throw new BadSubSectionName();
			}
			addNewSection(filter, order, sections, sectionWithOrderLine,
					filterWarning, orderWarning);
		}
	}

	/*
	 * help method for parseSections().
	 * 
	 * @param filter a filter to add to the section.
	 * 
	 * @param order an order to add to the section
	 * 
	 * @param sections an araylist of sections.
	 * 
	 * @param sectionWithOrderLine true of there is an order line description in
	 * the section.
	 */
	private static void addNewSection(Filter filter, Order order,
			ArrayList<Section> sections, boolean sectionWithOrderLine,
			boolean filterWarning, boolean orderWarning) {
		Section newSection;
		newSection = new Section(filter, order, filterWarning, orderWarning,
				sectionWithOrderLine);
		sections.add(newSection);

	}
}
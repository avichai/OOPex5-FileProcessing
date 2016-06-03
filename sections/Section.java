package oop.ex5.sections;

import oop.ex5.filters.Filter;
import oop.ex5.orders.Order;

/**
 * A class that represent a section.
 * 
 * @author Avichai
 *
 */
public class Section {
	private Filter filter;
	private Order order;
	private boolean filterWarning;
	private boolean orderWarning;
	private boolean sectionWithOrderLine;

	/**
	 * Constructor for a section.
	 * 
	 * @param filter
	 *            the filter for this section.
	 * @param order
	 *            the order for this section.
	 * @param filterWarning
	 *            is there a warning in the filter.
	 * @param orderWarning
	 *            if there a warning in the order.
	 * @param sectionWithOrderLine
	 *            does the section has an order description line.
	 */
	public Section(Filter filter, Order order, boolean filterWarning,
			boolean orderWarning, boolean sectionWithOrderLine) {
		this.filter = filter;
		this.order = order;
		this.filterWarning = filterWarning;
		this.orderWarning = orderWarning;
		this.sectionWithOrderLine = sectionWithOrderLine;
	}

	/**
	 * 
	 * @return true if the section has order description line and false
	 *         otherwise.
	 */
	public boolean isSectionWithOrderLine() {
		return this.sectionWithOrderLine;
	}

	/**
	 * 
	 * @return true if there is a filter warning and false otherwise.
	 */
	public boolean isFilterWarning() {
		return this.filterWarning;
	}

	/**
	 * 
	 * @return true if there is an order warning and false otherwise.
	 */
	public boolean isOrderWarning() {
		return this.orderWarning;
	}

	/**
	 * 
	 * @return the filter of this section.
	 */
	public Filter getFilter() {
		return this.filter;
	}

	/**
	 * 
	 * @return the order of this section.
	 */
	public Order getOrder() {
		return this.order;
	}

}

package com.oschrenk.fluentbool;

/**
 * A {@link BoolFilter} that always returns <b>false</b>. It is a representation of a
 * false value in a boolean algebra.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmx.net>
 *
 * @param <T> The type under inspection
 */
public abstract class FalseFilter<T> implements BoolFilter<T> {

	/**
	 * Empty default constructor. Just referenced when this class gets extended.
	 */
	public FalseFilter() {
		//can be ignored
	}
	
	/**
	 * Always returns <code>false</code>
	 */
	@Override
	public boolean accept(T type) {
		return false;
	}
	
}

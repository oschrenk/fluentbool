package com.oschrenk.fluentbool;

/**
 * A {@link BoolFilter} that always returns true. It is a representation of a true
 * value in a boolean algebra.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmx.net>
 *
 * @param <T> The type under inspection
 */
public abstract class TrueFilter<T> implements BoolFilter<T> {

	/**
	 * Empty default constructor. Just referenced when this class gets extended.
	 */
	public TrueFilter() {
		//can be ignored
	}
	
	/**
	 * Always returns <code>true</code>
	 */
	@Override
	public boolean accept(T type) {
		// TODO Auto-generated method stub
		return true;
	}
	
}

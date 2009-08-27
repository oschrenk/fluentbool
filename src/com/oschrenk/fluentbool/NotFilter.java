package com.oschrenk.fluentbool;

/**
 * A {@link BoolFilter} that works as the unary operator <b>not</b> like its
 * equivalent in a boolean algebra.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmx.net>
 *
 * @param <T> The type under inspection
 */
public abstract class NotFilter<T> implements BoolFilter<T> {
	
	private BoolFilter<T> filter;
	
	/**
	 * <p>Constructs a new {@link BoolFilter} working like the unary operator 
	 * <b>Not</b> in a boolean algebra.</p>
	 * 
	 * @param left The variable under inspection
	 */
	public NotFilter (BoolFilter<T> filter) {
		this.filter = filter;
	}
	
	/**
	 * <p>Returns the negation of the passed filter, so that <code>false</code>
	 * becomes <code>true</code> and vice versa.</p> 
	 */
	@Override
	public boolean accept(T type) {
		return !filter.accept(type);
	}
	
}
package com.oschrenk.fluentbool;

/**
 * A {@link BoolFilter} that works as the binary operator <b>or</b> like its
 * equivalent in a boolean algebra.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmx.net>
 *
 * @param <T> The type under inspection
 */
public abstract class OrFilter<T> implements BoolFilter<T> {
	
	private BoolFilter<T> left;
	private BoolFilter<T> right;
	
	/**
	 * <p>Constructs a new {@link BoolFilter} working like the binary operator 
	 * <b>Or</b> in a boolean algebra.</p>
	 * 
	 * @param left The variable left of the operator
	 * @param right The variable right of the operator
	 */
	public OrFilter (BoolFilter<T> left, BoolFilter<T> right) {
		this.left = left;
		this.right = right;;
	}
	
	/**
	 * <p>Returns the value of both filter combined with the boolean <b>and</b>
	 *  operator.</p>
	 */
	@Override
	public boolean accept(T type) {
		return left.accept(type) || right.accept(type);
	}

}

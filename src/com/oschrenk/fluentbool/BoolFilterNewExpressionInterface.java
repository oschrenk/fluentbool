package com.oschrenk.fluentbool;

/**
 * <p>
 * This interface is part of the fluent interface (also see
 * {@link BoolFilterNoOperatorInterface} and
 * {@link BoolFilterCloseBracketInterface}) that provides a natural approach
 * when creating filtering systems based on a boolan algebra.
 * </p>
 * 
 * <p>
 * It is used when the current state of the expression only allows for new
 * (sub-) epxressions to be created. That is especially the case in the very
 * beginning, after constructing a new {@link BoolExpressionFilter}, or after
 * opening a bracket, or starting a negating expression
 * </p>
 * 
 * <p>
 * For more details on the grammar, please see {@link BoolFilterStateMachine}
 * </p>
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmx.net>
 * 
 * @param <T>
 *            the type under inspection
 */
public interface BoolFilterNewExpressionInterface<T> {

	/**
	 * Starts a new Expression by adding a simple {@link BoolFilter}
	 * 
	 * @param filter
	 *            the {@link BoolFilter} to add.
	 * @return FluentInterface that allows to add binary operations, or closing
	 *         of the current expression
	 */
	BoolFilterNoOperatorInterface<T> start(BoolFilter<T> filter);

	/**
	 * Negates the following value or expression. It is possible to call
	 * <code>not().not()</code> but has no effect.
	 * 
	 * @return FluentInterface that allows to start a new expression
	 */
	BoolFilterNewExpressionInterface<T> not();

	/**
	 * Opens a new bracket and awaits a stat of a new expression no effect, just
	 * as one would expect.
	 * 
	 * @return FluentInterface that allows to add binary operations, or closing
	 *         of the current expression
	 */
	BoolFilterNewExpressionInterface<T> openBracket();

	/**
	 * Returns the {@link BoolFilter} that was created
	 * 
	 * @return the {@link BoolFilter} that was created
	 * @throws IllegalStateException
	 *             if the expression was not valid (e.g. not all brackets were
	 *             closed)
	 */
	BoolFilter<T> get() throws IllegalStateException;

}

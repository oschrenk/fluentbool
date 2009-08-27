package com.oschrenk.fluentbool;

/**
 * <p>
 * This interface is part of the fluent interface (also see
 * {@link BoolFilterNewExpressionInterface} and
 * {@link BoolFilterNoOperatorInterface}) that provides a natural approach when
 * creating filtering systems based on a boolan algebra.
 * </p>
 * 
 * <p>
 * In a boolean algebra you are allowed to close a bracket, if the expression
 * created so far is valid and does not end with an open binary operation and if
 * a bracket has been opened before.
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
public interface BoolFilterCloseBracketInterface<T> {

	/**
	 * Opens a new bracket and awaits a stat of a new expression no effect, just
	 * as one would expect.
	 * 
	 * @return FluentInterface that allows to add binary operations, or closing
	 *         of the current expression
	 */
	BoolFilterNewExpressionInterface<T> closeBracket();

}

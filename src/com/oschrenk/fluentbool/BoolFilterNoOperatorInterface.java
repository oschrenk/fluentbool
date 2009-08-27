package com.oschrenk.fluentbool;

/**
 * <p>
 * This interface is part of the fluent interface (also see
 * {@link BoolFilterNewExpressionInterface} and
 * {@link BoolFilterCloseBracketInterface}) that provides a natural approach
 * when creating filtering systems based on a boolan algebra.
 * </p>
 * 
 * <p>
 * It is used when the current state of the expression only allows operators
 * like {@link #or()}, {@link #or(BoolFilter)}, or {@link #and()} , or
 * {@link #and(BoolFilter)} to be added or to close the current expression.
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
public interface BoolFilterNoOperatorInterface<T> {

	/**
	 * Adds an <code>and</code> operator to the expression. Mus be followed by
	 * an expression.
	 * 
	 * @return FluentInterface that allows to add binary operations, or closing
	 *         of the current expression
	 */
	BoolFilterNoOperatorInterface<T> and();

	/**
	 * <p>
	 * Adds an <code>or</code> operator to the expression.
	 * </p>
	 * <p>
	 * In contrast to {@link #or(BoolFilter)} it is normally followed by a
	 * {@link BoolFilterNewExpressionInterface#not} or and
	 * {@link BoolFilterNewExpressionInterface#openBracket()}
	 * </p>
	 * *
	 * <p>
	 * Example:<br/>
	 * <code>[...]().or().openBracket().[...]</code>
	 * </p>
	 * 
	 * @return FluentInterface that allows to add binary operations, or closing
	 *         of the current expression
	 */
	BoolFilterNoOperatorInterface<T> or();

	/**
	 * <p>
	 * Adds an <code>and</code> operator and a {@link BoolFilter} to the current
	 * expression.
	 * </p>
	 * <p>
	 * Shorthand method for <code>and().start(A)</code>
	 * </p>
	 * <p>
	 * Example:<br/>
	 * <code>[...]().and(new ExampleFilter()).[...]</code>
	 * </p>
	 * 
	 * @param filter
	 *            the {@link BoolFilter} to add
	 * @return FluentInterface that allows to start a new expression
	 */
	BoolFilterNewExpressionInterface<T> and(BoolFilter<T> filter);

	/**
	 * <p>
	 * Adds an <code>or</code> operator and a {@link BoolFilter} to the current
	 * expression.
	 * </p>
	 * <p>
	 * Shorthand method for <code>or().start(A)</code>
	 * </p>
	 * <p>
	 * Example:<br/>
	 * <code>[...]().and(new ExampleFilter()).[...]</code>
	 * </p>
	 * 
	 * @param filter
	 *            the {@link BoolFilter} to add
	 * @return FluentInterface that allows to start a new expression
	 */
	BoolFilterNewExpressionInterface<T> or(BoolFilter<T> filter);

}

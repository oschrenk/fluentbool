package com.oschrenk.fluentbool;

/**
 * <p>
 * This class helps the developer create a new Filter based on a boolean algebra
 * expression.
 * </p>
 * <p>
 * I does so by providing a fluent interface, that allows a natural approach to
 * creating simple and complex expressions.
 * </p>
 * 
 * <p>
 * Examples:<br/>
 * 
 * <pre>
 * (A &amp;&amp; !B) || (!A &amp;&amp; B)
 * </pre>
 * 
 * can be created by calling
 * 
 * <pre>
 * new BoolExpressionFilter().
 * 		openBracket().start(A).and().not(B).closeBracket().
 * 		or().
 * 		openBracket().not(A).and(B).closeBracket().return();
 * </pre>
 * 
 * </p>
 * 
 * <p>
 * The variables <i>A</i> and <i>B</i> would be various implementations of a
 * {@link BoolFilter}. This expression allows for a very simple (though a bit
 * verbatim) modelling of very complex filter system.
 * </p>
 * 
 * <p>
 * Examplary implementations can be found in the
 * <code>com.oschrenk.fluenbool.examples</code> package.
 * 
 * <p>
 * Normally th approach would be to create a new filter that combines all the
 * single filter. This class allows for better reuse of these single filters,
 * but costs a little overhead, when creating the BoolExpression.
 * </p>
 * 
 * <p>
 * The implementation can also serve as a template for other uses of a boolean
 * algebra.
 * </p>
 * 
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmx.net>
 * 
 * @param <T> the type under inspection
 */
public abstract class BoolExpressionFilter<T> implements
		BoolFilterNewExpressionInterface<T> {

	/** A reference to the state machine, that constructs the filter */
	private BoolFilterStateMachine<T> state;

	/**
	 * Default empty constructor.
	 */
	public BoolExpressionFilter() {
		this.state = new BoolFilterStateMachine<T>();
	}

	/**
	 * Returns a valid filter based on the boolean algebra expression used to
	 * create it.
	 * 
	 * @return a valid filter based on the boolean algebra expression used to
	 *         create it.
	 * @throws IllegalStateException
	 *             if the expression used, was not valid.
	 */
	@Override
	public BoolFilter<T> get() throws IllegalStateException {
		return state.get(); // get method also validates by throwing
							// RuntimeException
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BoolFilterNewExpressionInterface<T> not() {
		state.not();
		return state.getNewExpressionImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BoolFilterNewExpressionInterface<T> openBracket() {
		state.openBracket();
		return state.getNewExpressionImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BoolFilterNoOperatorInterface<T> start(BoolFilter<T> filter) {
		state.start(filter);
		return state.getNoOperatorImpl();
	}

}

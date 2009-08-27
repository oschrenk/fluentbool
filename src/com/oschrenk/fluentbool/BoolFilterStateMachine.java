package com.oschrenk.fluentbool;

import java.util.IllegalFormatException;
import java.util.Stack;

/**
 * <p>
 * The {@link BoolExpressionFilterNewsExpressionImpl} takes care of the current
 * state of the {@link BoolExpressionFilter} to be returned. In the chosen
 * approach to create boolean algebra exprssion with a fluent interface, the
 * state machine only returns objects that allows valid manipulation of the
 * curent expression. This is a (complete) object driven approach, reducing the
 * number of states to manage, as the interface does not even allow to create
 * invalid objects.
 * </p>
 * 
 * <p>
 * Unfortunately the opening and closing of brackets is hard to handle with and
 * object oriented approach. It is allowed to close a bracket in evry state,
 * when creating an expression, even you didnt' open one. This will throw a
 * {@link IllegalStateException} when trying to return or validate the expression.
 * </p>
 * 
 * <p>
 * The approach reduces the complexity managing the state, but adds overhead in
 * creating the desired object, as there are multiple objects to be created and
 * referenced to.
 * </p>
 * 
 * <p>
 * For most projects this overhead would be too much. The target audience of
 * this poject is the scripting community and people generally interested in
 * fluent interfaces and object oriented programming experiments.
 * </p>
 * 
 * <p>
 * //TODO grammar
 * </p>
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmx.net>
 * 
 * @param <T>
 */
class BoolFilterStateMachine<T> implements BoolFilterNewExpressionInterface<T>,
		BoolFilterNoOperatorInterface<T>, BoolFilterCloseBracketInterface<T> {

	private State state;

	private int brackets;
	private int level;

	private Stack<BoolFilter<T>> stack;

	/** //TODO doc */
	private BoolFilterNewExpressionInterface<T> newExpressionImpl;
	private BoolFilterNoOperatorInterface<T> noOperatorImpl;

	/**
	 * Constructs a new State Machine. It should only be constructed from
	 * {@link BoolExpressionFilter}.
	 */
	protected BoolFilterStateMachine() {

		this.brackets = 0;
		this.level = 0;

		this.stack = new Stack<BoolFilter<T>>();

		this.newExpressionImpl = new BoolExpressionFilterNewExpressionImpl();
		this.noOperatorImpl = new BoolExpressionFilterNoOperatorImpl();
	}

	public void validate() throws IllegalStateException {
		if (state == State.NEW)
			throw new IllegalStateException(
					"The expression has no valid filter.");
	}

	public boolean isValid() {
		try {
			validate();
		} catch (IllegalFormatException e) {
			return false;
		}
		return true;
	}

	public BoolFilter<T> get() {
		validate();
		return null;
	}

	@Override
	public BoolFilterNewExpressionInterface<T> not() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoolFilterNewExpressionInterface<T> openBracket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoolFilterNoOperatorInterface<T> start(BoolFilter<T> filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoolFilterNoOperatorInterface<T> and() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoolFilterNewExpressionInterface<T> and(BoolFilter<T> filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoolFilterNewExpressionInterface<T> closeBracket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoolFilterNoOperatorInterface<T> or() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoolFilterNewExpressionInterface<T> or(BoolFilter<T> filter) {
		// TODO Auto-generated method stub
		return null;
	}

	protected BoolFilterNewExpressionInterface<T> getNewExpressionImpl() {
		return newExpressionImpl;
	}

	protected BoolFilterNoOperatorInterface<T> getNoOperatorImpl() {
		return noOperatorImpl;
	}

	enum State {
		NEW;
	}

	/**
	 * {@inheritDoc}
	 */
	class BoolExpressionFilterNewExpressionImpl implements
			BoolFilterNewExpressionInterface<T>,
			BoolFilterCloseBracketInterface<T> {

		/** Reference to the state machine */
		protected BoolFilterStateMachine<T> state;

		/**
		 * Passses the new state machine
		 * 
		 * @param state
		 *            the new state
		 */
		protected void setState(BoolFilterStateMachine<T> state) {
			this.state = state;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public BoolFilter<T> get() {
			return state.get();
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

		@Override
		public BoolFilterNewExpressionInterface<T> closeBracket() {
			state.closeBracket();
			return state.getNewExpressionImpl();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	class BoolExpressionFilterNoOperatorImpl implements
			BoolFilterNoOperatorInterface<T>,
			BoolFilterCloseBracketInterface<T> {

		/** Reference to the state machine */
		protected BoolFilterStateMachine<T> state;

		/**
		 * Passes the state machine
		 * 
		 * @param state
		 *            the new state
		 */
		protected void setState(BoolFilterStateMachine<T> state) {
			this.state = state;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public BoolFilterNoOperatorInterface<T> and() {
			state.and();
			return state.getNoOperatorImpl();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public BoolFilterNewExpressionInterface<T> and(BoolFilter<T> filter) {
			state.and(filter);
			return state.getNewExpressionImpl();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public BoolFilterNoOperatorInterface<T> or() {
			state.or();
			return state.getNoOperatorImpl();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public BoolFilterNewExpressionInterface<T> or(BoolFilter<T> filter) {
			state.or(filter);
			return state.getNewExpressionImpl();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public BoolFilterNewExpressionInterface<T> closeBracket() {
			state.closeBracket();
			return state.getNewExpressionImpl();
		}

	}

}

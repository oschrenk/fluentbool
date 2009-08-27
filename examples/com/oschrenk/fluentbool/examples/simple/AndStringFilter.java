package com.oschrenk.fluentbool.examples.simple;

import com.oschrenk.fluentbool.AndFilter;
import com.oschrenk.fluentbool.BoolFilter;

/**
 * {@inheritDoc}
 */
public class AndStringFilter extends AndFilter<String> {

	/**
	 * {@inheritDoc}
	 */
	public AndStringFilter(BoolFilter<String> left, BoolFilter<String> right) {
		super(left, right);
	}

}

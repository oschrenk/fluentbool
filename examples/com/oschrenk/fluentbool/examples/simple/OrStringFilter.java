package com.oschrenk.fluentbool.examples.simple;

import com.oschrenk.fluentbool.BoolFilter;
import com.oschrenk.fluentbool.OrFilter;

/**
 * {@inheritDoc}
 */
public class OrStringFilter extends OrFilter<String> {

	/**
	 * {@inheritDoc}
	 */
	public OrStringFilter(BoolFilter<String> left, BoolFilter<String> right) {
		super(left, right);
	}

}

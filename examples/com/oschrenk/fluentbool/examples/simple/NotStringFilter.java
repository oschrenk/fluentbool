package com.oschrenk.fluentbool.examples.simple;

import com.oschrenk.fluentbool.BoolFilter;
import com.oschrenk.fluentbool.NotFilter;

/**
 * {@inheritDoc}
 */
public class NotStringFilter extends NotFilter<String> {

	/**
	 * {@inheritDoc}
	 */
	public NotStringFilter(BoolFilter<String> filter) {
		super(filter);
	}

}

package com.oschrenk.fluentbool;

public interface BoolFilter<T> {
	boolean accept (T type);
}

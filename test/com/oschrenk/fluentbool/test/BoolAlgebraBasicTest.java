package com.oschrenk.fluentbool.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.oschrenk.fluentbool.AndFilter;
import com.oschrenk.fluentbool.FalseFilter;
import com.oschrenk.fluentbool.NotFilter;
import com.oschrenk.fluentbool.OrFilter;
import com.oschrenk.fluentbool.TrueFilter;
import com.oschrenk.fluentbool.examples.simple.AndStringFilter;
import com.oschrenk.fluentbool.examples.simple.FalseStringFilter;
import com.oschrenk.fluentbool.examples.simple.NotStringFilter;
import com.oschrenk.fluentbool.examples.simple.OrStringFilter;
import com.oschrenk.fluentbool.examples.simple.TrueStringFilter;

public class BoolAlgebraBasicTest {

	/**
	 * Just some arbitrary text used for test cases. As these basic test
	 * cases don't care for the content, the text can be arbitrary
	 */
	private static final String TEXT = "SOME TEXT";
	
	private TrueFilter<String> trueFilter;
	private FalseFilter<String> falseFilter;
	
	private NotFilter<String> notFilter;
	
	private AndFilter<String> andFilter;
	private OrFilter<String> orFilter;
	
	
	@Before
	public void setUp() throws Exception {
		this.trueFilter  = new TrueStringFilter();
		this.falseFilter  = new FalseStringFilter();
	}

	@Test
	public void testTrueFilter() {
		assertTrue(trueFilter.accept(TEXT));
	}
	
	@Test
	public void testFalseFilter() {
		assertFalse(falseFilter.accept(TEXT));
	}
	
	@Test
	public void testNotFilter() {
		//True > False
		notFilter = new NotStringFilter(trueFilter);
		assertFalse(notFilter.accept(TEXT));
		
		//False > True
		notFilter = new NotStringFilter(falseFilter);
		assertTrue(notFilter.accept(TEXT));
	}
	
	@Test 
	public void testAndFilter() {
		//True, True > True
		andFilter = new AndStringFilter(trueFilter, trueFilter);
		assertTrue(andFilter.accept(TEXT));
		
		//True, False > False
		andFilter = new AndStringFilter(trueFilter, falseFilter);
		assertFalse(andFilter.accept(TEXT));
		
		//False, False > False
		andFilter = new AndStringFilter(falseFilter, falseFilter);
		assertFalse(andFilter.accept(TEXT));
		
		//False, True > False
		andFilter = new AndStringFilter(falseFilter, trueFilter);
		assertFalse(andFilter.accept(TEXT));
	}
	
	@Test 
	public void testOrFilter() {
		//True, True > True
		orFilter = new OrStringFilter(trueFilter, trueFilter);
		assertTrue(orFilter.accept(TEXT));
		
		//True, False > True
		orFilter = new OrStringFilter(trueFilter, falseFilter);
		assertTrue(orFilter.accept(TEXT));
		
		//False, False > False
		orFilter = new OrStringFilter(falseFilter, falseFilter);
		assertFalse(orFilter.accept(TEXT));
		
		//False, True > True
		orFilter = new OrStringFilter(falseFilter, trueFilter);
		assertTrue(orFilter.accept(TEXT));
	}
	
}

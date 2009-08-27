package com.oschrenk.fluentbool.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.oschrenk.fluentbool.AndFilter;
import com.oschrenk.fluentbool.FalseFilter;
import com.oschrenk.fluentbool.OrFilter;
import com.oschrenk.fluentbool.TrueFilter;
import com.oschrenk.fluentbool.examples.simple.AndStringFilter;
import com.oschrenk.fluentbool.examples.simple.FalseStringFilter;
import com.oschrenk.fluentbool.examples.simple.NotStringFilter;
import com.oschrenk.fluentbool.examples.simple.OrStringFilter;
import com.oschrenk.fluentbool.examples.simple.TrueStringFilter;

public class BoolAlgebraAdvancedTest {

	/**
	 * Just some arbitrary text used for test cases. As these basic test
	 * cases don't care for the content, the text can be arbitrary
	 */
	private static final String TEXT = "SOME TEXT";
	
	private TrueFilter<String> trueFilter;
	private FalseFilter<String> falseFilter;
	
	@Before
	public void setUp() throws Exception {
		this.trueFilter  = new TrueStringFilter();
		this.falseFilter  = new FalseStringFilter();
	}
	
	/**
	 * <p>True if and only if one of the variables are true></p>
	 * 
	 * <p>
	 * <code>(A && !B) || (!A && B)</code>
	 * </p>
	 * 
	 */
	@Test
	public void testXorFilter() {
		AndFilter<String> leftAndFilter;
		AndFilter<String> righttAndFilter;
		OrFilter<String> xorFilter;
		
		// True, True > False
		leftAndFilter = new AndStringFilter(trueFilter, new NotStringFilter(trueFilter));
		righttAndFilter = new AndStringFilter(new NotStringFilter(trueFilter), trueFilter);
		xorFilter = new OrStringFilter(leftAndFilter, righttAndFilter);
		assertFalse(xorFilter.accept(TEXT));
		
		// True, False > True
		leftAndFilter = new AndStringFilter(trueFilter, new NotStringFilter(falseFilter));
		righttAndFilter = new AndStringFilter(new NotStringFilter(trueFilter), falseFilter);
		xorFilter = new OrStringFilter(leftAndFilter, righttAndFilter);
		assertTrue(xorFilter.accept(TEXT));
		
		// False, False > False
		leftAndFilter = new AndStringFilter(falseFilter, new NotStringFilter(falseFilter));
		righttAndFilter = new AndStringFilter(new NotStringFilter(falseFilter), falseFilter);
		xorFilter = new OrStringFilter(leftAndFilter, righttAndFilter);
		assertFalse(xorFilter.accept(TEXT));
		
		// False, True > True
		leftAndFilter = new AndStringFilter(falseFilter, new NotStringFilter(trueFilter));
		righttAndFilter = new AndStringFilter(new NotStringFilter(falseFilter), trueFilter);
		xorFilter = new OrStringFilter(leftAndFilter, righttAndFilter);
		assertTrue(xorFilter.accept(TEXT));
	}
	
	/**
	 *	Implicate: If A is true B is also true
	 *	A -> B
	 * 
	 *	or
	 *
	 *	!A || B
	 */
	@Test
	public void testImplicateFilter() {
		OrFilter<String> implicateFilter;
		
		// True, True > True
		implicateFilter = new OrStringFilter(new NotStringFilter(trueFilter), trueFilter);
		assertTrue(implicateFilter.accept(TEXT));
		
		// True, False > False
		implicateFilter = new OrStringFilter(new NotStringFilter(trueFilter), falseFilter);
		assertFalse(implicateFilter.accept(TEXT));
		
		// False, False > True
		implicateFilter = new OrStringFilter(new NotStringFilter(falseFilter), falseFilter);
		assertTrue(implicateFilter.accept(TEXT));
		
		// False, True > True
		implicateFilter = new OrStringFilter(new NotStringFilter(falseFilter), trueFilter);
		assertTrue(implicateFilter.accept(TEXT));
	}
	
	
}

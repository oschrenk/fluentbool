package com.oschrenk.fluentbool.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  BoolAlgebraBasicTest.class,
  BoolAlgebraAdvancedTest.class,
  BoolAlgebraExpressionTest.class 
})

public class AllTests {
	//don't have to create or destroy anything
}

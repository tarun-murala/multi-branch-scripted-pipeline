package com.tarun;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DivisionTest extends TestCase {

	public void testOperation() {
		Assert.assertEquals(2, new Division().operation(4, 2));
	}

}

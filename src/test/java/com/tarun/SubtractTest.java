package com.tarun;

import junit.framework.Assert;
import junit.framework.TestCase;

public class SubtractTest extends TestCase {

	public void testOperation() {
		Assert.assertEquals(2, new Subtract().operation(4, 2));
	}

}

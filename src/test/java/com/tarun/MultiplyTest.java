package com.tarun;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MultiplyTest extends TestCase {

	public void testOperation() {
		Assert.assertEquals(4, new Multiply().operation(2, 2));
	}

}

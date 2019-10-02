package com.tarun;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AddTest extends TestCase {
	
	public void testAdd() {
		Assert.assertEquals(2, new Add().operation(1, 1));
	}

}

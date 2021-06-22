package com.cashcard.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cashcard.BlanceCheckServices;
import com.cashcard.DepositeServices;

import junit.framework.Assert;

public class BlanceCheckServicesTest {
	@BeforeClass
	public static void setup() throws Exception {
		DepositeServices ds = new DepositeServices();
		ds.deposite(500);
	}
	
	
	@Test
	public void blanceCheckTest() throws Exception {
		BlanceCheckServices bc=new BlanceCheckServices();
		Assert.assertEquals(500, bc.blanceCheck());
	}
	
}

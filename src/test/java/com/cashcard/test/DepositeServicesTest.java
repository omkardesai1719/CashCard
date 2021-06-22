package com.cashcard.test;

import org.junit.Test;

import com.cashcard.DepositeServices;
import com.cashcard.exception.NegativeAmountException;

import junit.framework.Assert;

public class DepositeServicesTest {

	@Test
	public void testDepositePositiveAmount() throws Exception {
		DepositeServices ds = new DepositeServices();
		int totalBal = ds.deposite(500);
		Assert.assertEquals(500, totalBal);
	}
	
	@Test(expected = NegativeAmountException.class)
	public void testDepositeNegativeAmount() throws Exception {
		DepositeServices ds = new DepositeServices();
		ds.deposite(-10);
	}
	
}

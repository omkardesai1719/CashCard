package com.cashcard.test;

import org.junit.Test;

import com.cashcard.DepositeService;
import com.cashcard.exception.NegativeAmountException;

import junit.framework.Assert;

public class DepositeServiceTest {

	@Test
	public void testDepositePositiveAmount() throws Exception {
		DepositeService ds = new DepositeService();
		int totalBal = ds.deposite(500);
		Assert.assertEquals(500, totalBal);
	}
	
	@Test(expected = NegativeAmountException.class)
	public void testDepositeNegativeAmount() throws Exception {
		DepositeService ds = new DepositeService();
		ds.deposite(-10);
	}
	
}

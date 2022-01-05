package com.cashcard.test;

import org.junit.Test;

import com.cashcard.DepositService;
import com.cashcard.exception.NegativeAmountException;

import junit.framework.Assert;

public class DepositServiceTest {

	@Test
	public void testDepositePositiveAmount() throws Exception {
		DepositService ds = new DepositService();
		int totalBal = ds.deposite(500);
		Assert.assertEquals(500, totalBal);
	}

	@Test(expected = NegativeAmountException.class)
	public void testDepositeNegativeAmount() throws Exception {
		DepositService ds = new DepositService();
		ds.deposite(-20);
	}

}

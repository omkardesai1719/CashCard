package com.cashcard.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cashcard.BalanceCheckService;
import com.cashcard.DepositService;

import junit.framework.Assert;

public class BalanceCheckServiceTest {
	@BeforeClass
	public static void setup() throws Exception {
		DepositService ds = new DepositService();
		ds.deposite(500);
	}

	@Test
	public void balanceCheckTest() throws Exception {
		BalanceCheckService bc = new BalanceCheckService();
		Assert.assertEquals(500, bc.balanceCheck());
	}

}

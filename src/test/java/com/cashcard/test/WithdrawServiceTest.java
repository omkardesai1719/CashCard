package com.cashcard.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cashcard.DepositService;
import com.cashcard.WithdrawService;
import com.cashcard.exception.InsufficientFundExcepetion;
import com.cashcard.exception.NegativeAmountException;

import junit.framework.Assert;

public class WithdrawServiceTest {

	@BeforeClass
	public static void setup() throws Exception {
		DepositService ds = new DepositService();
		ds.deposite(500);
	}

	@Test
	public void withdrawAmountPositiveTest() throws Exception {
		WithdrawService ws = new WithdrawService();
		Assert.assertEquals(300, ws.withdraw(200));
	}

	@Test(expected = InsufficientFundExcepetion.class)
	public void withdrawNegativeAmountTest() throws Exception {
		WithdrawService ws = new WithdrawService();
		ws.withdraw(1800);
	}

	@Test(expected = NegativeAmountException.class)
	public void withdrawNegativeAmountTest1() throws Exception {
		WithdrawService ws = new WithdrawService();
		ws.withdraw(-100);
	}

}

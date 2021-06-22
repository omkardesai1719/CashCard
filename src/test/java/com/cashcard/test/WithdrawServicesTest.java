package com.cashcard.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cashcard.DepositeServices;
import com.cashcard.WithdrawServices;
import com.cashcard.exception.InsufficientFundExcepetion;
import com.cashcard.exception.NegativeAmountException;

import junit.framework.Assert;

public class WithdrawServicesTest {
	
	@BeforeClass
	public static void setup() throws Exception {
		DepositeServices ds = new DepositeServices();
		ds.deposite(500);
	}
	
	@Test
	public void withdrawAmount1() throws Exception {
		WithdrawServices ws=new WithdrawServices();
		Assert.assertEquals(300, ws.withdraw(200));
	}
	
	@Test(expected = InsufficientFundExcepetion.class)
	public void withdrawAmount2() throws Exception {
		WithdrawServices ws=new WithdrawServices();
		ws.withdraw(1800);
	}
	
	@Test(expected = NegativeAmountException.class)
	public void testWithdrawNegativeAmount() throws Exception {
		WithdrawServices ws=new WithdrawServices();
		ws.withdraw(-100);
	}
	
}

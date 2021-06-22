package com.cashcard.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cashcard.BlanceCheckService;
import com.cashcard.DepositeService;

import junit.framework.Assert;

public class BlanceCheckServiceTest {
	@BeforeClass
	public static void setup() throws Exception {
		DepositeService ds = new DepositeService();
		ds.deposite(500);
	}
	
	
	@Test
	public void blanceCheckTest() throws Exception {
		BlanceCheckService bc=new BlanceCheckService();
		Assert.assertEquals(500, bc.blanceCheck());
	}
	
}

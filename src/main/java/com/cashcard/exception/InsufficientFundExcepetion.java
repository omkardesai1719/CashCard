package com.cashcard.exception;

public class InsufficientFundExcepetion extends Exception{
	 
		private static final long serialVersionUID = 1L;

		public InsufficientFundExcepetion() {
			super("You have insufficient balance.");
		}
}

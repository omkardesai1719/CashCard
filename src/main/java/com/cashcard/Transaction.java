package com.cashcard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Transaction {

	private static final String DEPOSITE = "1";
	private static final String WITHDRAW = "2";
	private static final String BALANCE_CHECK = "3";
	private static final String EXIT = "4";

	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {
		String option = "";
		DepositService ds = new DepositService();
		WithdrawService ws = new WithdrawService();
		BalanceCheckService bs = new BalanceCheckService();

		do {
			try {
				System.out.println("Choose Any Option");
				System.out.println("1. Deposit");
				System.out.println("2. Withdraw");
				System.out.println("3. Balance Check");
				System.out.println("4. Exit");
				System.out.println("Enter Operation");
				Scanner opt = new Scanner(System.in);
				option = opt.nextLine();

				switch (option) {
				case DEPOSITE:
					int depositeAmount = 0;
					System.out.println("Enter Ammount to be Deposit");
					depositeAmount = opt.nextInt();
					System.out.println("total balance : " + ds.deposite(depositeAmount));
					break;
				case WITHDRAW:
					int withdrawAmount = 0;
					System.out.println("Enter Ammount to be Withdraw");
					withdrawAmount = opt.nextInt();
					System.out.println("total balance : " + ws.withdraw(withdrawAmount));
					break;
				case BALANCE_CHECK:
					System.out.println("total balance : " + bs.balanceCheck());
					break;
				case EXIT:
					System.exit(0);
					break;
				default:
					System.err.println("Invalid Option Entered.");
				}

			} catch (InputMismatchException e) {
				System.err.println("Invalid Input");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} while (!"4".equals(option));

	}

}

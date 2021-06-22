package com.cashcard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;  

public class CreditDebit {
  
	public static void main(String[] args) {
		showMenu();
	}
	
	private static void showMenu() {
		String option = "";
		DepositeServices ds=new DepositeServices();
		WithdrawServices ws=new WithdrawServices();
		BlanceCheckServices bs=new BlanceCheckServices();
		
		do {
			try {
			System.out.println("Choose Any Option");
			System.out.println("1. Deposite");
			System.out.println("2. Withdraw");
			System.out.println("3. Balance Check");	
			System.out.println("4. Exit");	
			System.out.println("Enter Operation");
			Scanner opt = new Scanner(System.in);
			option = opt.nextLine();
			
			if(option.equals("1")) {
				//get input from user
				int depositeAmount=0;
				System.out.println("Enter Ammount to be Deposite");
				try{
		            depositeAmount = opt.nextInt();
		        }catch (java.util.InputMismatchException e){
		            System.err.println("Invalid Input");
		        }
				System.out.println("total balance : " + ds.deposite(depositeAmount));
			}else if(option.equals("2")) {
				int withdrawAmount=0;
				System.out.println("Enter Ammount to be Withdraw");
				try{
					withdrawAmount = opt.nextInt();
		        }catch (java.util.InputMismatchException e){
		            System.err.println("Invalid Input");
		        }
				System.out.println("total balance : "+ws.withdraw(withdrawAmount));
			}else if(option.equals("3")) {
				System.out.println("total balance : "+ bs.blanceCheck());
			}else if(option.equals("4")) {
				System.exit(0);
			}else {
				System.err.println("Invalid Option Entered.");
			}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}while(!"4".equals(option));
		
		
	}
	

}
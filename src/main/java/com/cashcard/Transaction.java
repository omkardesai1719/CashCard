package com.cashcard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;  

public class Transaction {
  
	public static void main(String[] args) {
		showMenu();
	}
	
	private static void showMenu() {
		String option = "";
		DepositeService ds=new DepositeService();
		WithdrawService ws=new WithdrawService();
		BlanceCheckService bs=new BlanceCheckService();
		
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
				
				switch(option)
		        {
		            case "1":
		            	int depositeAmount=0;
						System.out.println("Enter Ammount to be Deposite");
						try{
				            depositeAmount = opt.nextInt();
				        }catch (InputMismatchException e){
				            System.err.println("Invalid Input");
				        }
						System.out.println("total balance : " + ds.deposite(depositeAmount));
		                break;
		            case "2":
		            	int withdrawAmount=0;
						System.out.println("Enter Ammount to be Withdraw");
						try{
							withdrawAmount = opt.nextInt();
				        }catch (InputMismatchException e){
				            System.err.println("Invalid Input");
				        }
						System.out.println("total balance : "+ws.withdraw(withdrawAmount));
		                break;
		            case "3":
		            	System.out.println("total balance : "+ bs.blanceCheck());
		                break;
		            case "4":
		            	System.exit(0);
		                break;
		            default:
		            	System.err.println("Invalid Option Entered.");
		        }
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}		
			
		}while(!"4".equals(option));
				
	}
	

}

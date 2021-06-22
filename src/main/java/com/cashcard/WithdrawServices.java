package com.cashcard;

import java.sql.ResultSet;
import java.sql.Statement;

import com.cashcard.exception.InsufficientFundExcepetion;
import com.cashcard.exception.NegativeAmountException;

public class WithdrawServices {
	public int withdraw(int amount) throws Exception {
		
		if(amount < 0) throw new NegativeAmountException("Withdraw Amount cannot be negative");
		return withdrawAmountAndUpdate(amount);
		
		
	}
	private int withdrawAmountAndUpdate(int amount) throws Exception {
		int totalBalance = 0;
		int withdrawAmount=0;
		int id=0;
		int balance=0;
		
		withdrawAmount = amount;
        
		
		try {
			Statement stmt = JDBCConnection.getConnection().createStatement();
			String sql1 = "SELECT id, balance FROM Account"; 
            ResultSet rs = stmt.executeQuery(sql1); 
            
            while(rs.next()) { 
                // Retrieve by column name 
                id  = rs.getInt("id"); 
                balance = rs.getInt("balance"); 
                
             }
            if(withdrawAmount<=balance) {
            	int deposite=balance-withdrawAmount;
            	totalBalance=deposite;
    			String sql = "UPDATE Account " + "SET balance = "+deposite+" WHERE id = "+id; 
    	        stmt.executeUpdate(sql);
    	        System.out.println(withdrawAmount+" amount withdraw successfully");
            }else {
            	totalBalance=balance;
            	throw new InsufficientFundExcepetion();
            }              			
	        
			
		}catch(Exception e) { 
	         //Handle errors for Class.forName 
	     
	         throw e;
	    }
		
		return totalBalance;
	}
}

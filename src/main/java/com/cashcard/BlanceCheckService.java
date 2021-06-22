package com.cashcard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BlanceCheckService {
	public int blanceCheck()  throws Exception {		
		return balancedAmount();
	}
	
	private int balancedAmount() throws Exception {
		int totalBalance = 0;
		try {
			Statement stmt = JDBCConnection.getConnection().createStatement();
        	String sql1 = "SELECT id, balance FROM Account"; 
            ResultSet rs = stmt.executeQuery(sql1); 
            
            while(rs.next()) { 
                // Retrieve by column name 
                int id  = rs.getInt("id"); 
                int balance = rs.getInt("balance"); 
                System.out.println("Total Balance "+ balance);
                totalBalance= balance;
             } 	
		}catch(Exception e) { 
	         //Handle errors for Class.forName 
	         throw e;
	    }
		
		return totalBalance;
	}
}

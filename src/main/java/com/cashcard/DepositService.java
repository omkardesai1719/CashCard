package com.cashcard;

import java.sql.ResultSet;
import java.sql.Statement;

import com.cashcard.exception.NegativeAmountException;

public class DepositService {
	public int deposite(int amount) throws Exception {

		if (amount < 0)
			throw new NegativeAmountException("Deposite Amount cannot be negative");
		return depositeAmountAndUpdate(amount);

	}

	private int depositeAmountAndUpdate(int amount) throws Exception {
		int totalBalance = 0;
		try {
			String sql1 = "SELECT id, balance FROM Account";
			Statement stmt = JDBCConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql1);
			int id = 0;
			int balance = 0;
			while (rs.next()) {
				// Retrieve by column name
				id = rs.getInt("id");
				balance = rs.getInt("balance");

			}

			totalBalance = amount + balance;

			String sql = "UPDATE Account " + "SET balance = " + totalBalance + " WHERE id = " + id;
			stmt.executeUpdate(sql);

			System.out.println(amount + " amount deposite successfully");

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			throw e;
		}
		return totalBalance;
	}
}

package com.cashcard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {

	private static final String JDBC_DRIVER = ConstantsVariables.Driver;
	private static final String DB_URL = ConstantsVariables.DB_URL;
	private static final String USER = ConstantsVariables.USER;
	private static final String PASS = ConstantsVariables.PASS;
	private static Connection conn;

	private static Connection createJDBCConnection() {
		Connection con = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			throw new IllegalStateException("Not able to connect DB");
		}
		return con;
	}

	private static void initH2DB() {
		try {
			Statement stmt = conn.createStatement();
			int tableCount = 0;
			ResultSet rs = stmt.executeQuery("Show tables");
			while (rs.next()) {
				if (rs.getString(1).equals("ACCOUNT")) {
					tableCount = 1;
				}
			}

			if (tableCount == 1) {
				String sql1 = "DROP TABLE Account";
				stmt.executeUpdate(sql1);
			}

			String sql = "CREATE TABLE   Account " + "(id INTEGER not NULL, " + " balance VARCHAR(255), "
					+ " PRIMARY KEY ( id ))";
			stmt.executeUpdate(sql);

			String sql2 = "INSERT INTO Account " + "VALUES (1, '0')";
			stmt.executeUpdate(sql2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (conn == null) {
			// Initialize coonection
			conn = createJDBCConnection();
			// init DB
			initH2DB();
		}
		return conn;
	}

	@Override
	protected void finalize() throws Throwable {
		conn.close();
		super.finalize();
	}
}

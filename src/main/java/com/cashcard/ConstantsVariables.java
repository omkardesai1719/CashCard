package com.cashcard;

public class ConstantsVariables {

	public static String Driver= SetProperties.getInstance().getProperties().getProperty("Driver");
	public static String DB_URL= SetProperties.getInstance().getProperties().getProperty("DB_URL");
	public static String USER= SetProperties.getInstance().getProperties().getProperty("USER");
	public static String PASS= SetProperties.getInstance().getProperties().getProperty("PASS");
}

package com.cashcard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SetProperties {
	
	private static SetProperties instance = null;
	private Properties properties;
	
	private SetProperties() {
		
	}
	
	public static SetProperties getInstance() {
		if(instance == null) {
			instance = new SetProperties();
		}
		
		return instance;
	}

	public Properties getProperties() {
		
		if(properties == null) {
			if(loadProperties()) {
				return properties;
			}else {
				return null;
			}
		}
		
		return properties;
	}
	
	public boolean loadProperties() {
		properties = new Properties();
		
		String propertiesPath="config.properties";		
		
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream(propertiesPath));
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return true;
	}
}

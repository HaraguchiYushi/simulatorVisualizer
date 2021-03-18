package com.yushi.simulator.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyControl {
	private static final String propertiesFilePath = System.getProperty("user.dir") + "/src/main/java/com/yushi/simulator/config/config.properties";
	private static PropertyControl propertyControl = null;
	private static Properties prop = null;

	private PropertyControl() {
		prop = new Properties();
		try {
			prop.load(new FileReader(propertiesFilePath));
		} catch(IOException e) {
			System.err.println("Can't open properties file.\n" + propertiesFilePath);
		}
	}
	
	public static PropertyControl getObject() {
		if(propertyControl == null) propertyControl = new PropertyControl();
		return propertyControl;
	}
	
	public String get(String key) {
		if(PropertyControl.prop == null) return null;
		else if(!prop.contains(key)) return (String) prop.get(key); else  return null;
	}
}
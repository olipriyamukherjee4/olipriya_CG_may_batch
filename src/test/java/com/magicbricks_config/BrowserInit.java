package com.magicbricks_config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BrowserInit {

	public static String getBrowserName() {
		
		return readPropertiesFile().getProperty("browserName");
	}
	
	public static Properties readPropertiesFile() {
		FileInputStream f;
		Properties prop=new Properties();
		{
			try {
				f=new FileInputStream("src/main/java/browser.properties");
				try {
					prop.load(f);
					
				}catch (IOException exception) {
					exception.printStackTrace();
				}
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

}

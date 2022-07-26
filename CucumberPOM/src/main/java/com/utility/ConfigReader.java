package com.utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	//To load the properties from config.properties file
	//It returns properties object
	
	
	public Properties init_prop(){
		
		prop = new Properties();
		
		
			
			try {
				FileInputStream ip = new FileInputStream(".src/test/resources/config/config.properties");
				prop.load(ip);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return prop;
			
	
}
}
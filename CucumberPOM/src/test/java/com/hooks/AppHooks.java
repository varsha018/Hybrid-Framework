package com.hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.factory.DriverFactory;
import com.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	private DriverFactory Dfactory; //linking with the driver factory
	
	private WebDriver driver;
	
	private ConfigReader configR;//Linking with configReader
	
	Properties prop;//get the value of properties from configReader here
	
	
	@Before(order = 0)
	public void GetProperty() {
		
		configR = new ConfigReader();
		
		prop = configR.init_prop();
	}
	
	@Before(order = 1)
	public void LaunchBrowser() {
		
		String BrowserName = prop.getProperty("browser");
		
		Dfactory = new DriverFactory();
		driver  = Dfactory.init_driver(BrowserName);	//store the browser name in driver
	}
	
	@After(order = 0)
	public void QuitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void TearDown(Scenario sc) {
		
		if(sc.isFailed()) {
			//take screenShot
			
			String ScreenShotName =  sc.getName().replaceAll(" " , "_");
			byte[] sourcePath =	((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);//use BYTES-->to use in Jenkins /CI-CD tool
			
			sc.attach(sourcePath, "image/png", ScreenShotName);
			
			
		}
		
		
		
		
	}
	

}

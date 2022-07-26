package com.factory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();  //with the help of thread local all the threads will get the same copy..

	
	//this method will initialize threadLocal Driver based on given Browser
	//FACTORY of browsers>> whichever available
	
	
	
	public WebDriver init_driver(String browser) {

		System.out.println("The browser value is ==> " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver()); //set the Driver at runtime

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver()); //set is void in nature->does not return anything

		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		}else {
			System.out.println("please pass the correct browser name ==> " + browser);
		}

		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}
	
	
	
	//this method is used to get the driver with ThreadLocal
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();  //get the Driver at runtime
		
		
	}
}

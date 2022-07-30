package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1-> By Locators / Object Repository

	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By SignIn = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");

	// 2-> Constructor of the page class

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3-> page Actions(features/behavior of page in form of methods

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public Boolean isForgotPasswordLinkPresent() {
		Boolean frgtpwdFlag = driver.findElement(forgotPwdLink).isDisplayed();
		return frgtpwdFlag;
	}

	public void getUserName(String username) { //here,connecting with loginPage feature file->same userName will be passed here
		driver.findElement(emailID).sendKeys(username); //userName that we passed in feature file...
	}
	
	public void getPassword(String pwd) { //here,connecting with loginPage feature file->same password will be passed here
		driver.findElement(password).sendKeys(pwd); 
	}
	
	public void ClickOnLogin() {
		driver.findElement(SignIn).click();
	}
	
	public AccountsPage doLogin(String un, String pw) {
		System.out.println("Login with : " + un + "and password : " + pw);
		
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(password).sendKeys(pw); 
		driver.findElement(SignIn).click();
		
		return new AccountsPage(driver); //page chaining concept
	}
	
	
	
	
	
	
}

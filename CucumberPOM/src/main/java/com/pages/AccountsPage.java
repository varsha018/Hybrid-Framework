package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By AccountSections = By.cssSelector("div#center_column span"); //all headers of the account page by cssSelector
	
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAcctnPageTitle() {
		String t1 =  driver.getTitle();
		return t1;
		
	}
	
	
	public int getAccountSectionCount() { //get the count of headers
		
		return driver.findElements(AccountSections).size() ;
	}
	
	public List<String> getAccountSctionList() { //get the list count
		
		List<String> accList = new ArrayList<>();
		
		List<WebElement> accSecList = driver.findElements(AccountSections);
		
		for(WebElement e : accSecList ) {
			String txt = e.getText();
			System.out.println(txt);
			
			accList.add(txt); //add all the header text in arraylist	
		}
		
		return accList; //return the list
	}
	
}

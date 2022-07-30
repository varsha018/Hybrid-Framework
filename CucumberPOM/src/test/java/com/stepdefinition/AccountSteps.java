package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountSteps {
	
	private LoginPage L_Page = new LoginPage(DriverFactory.getDriver());
	private AccountsPage A_Page;
	
	
	@Given("User has already logged in the application")
	public void user_has_already_logged_in_the_application(DataTable CredentialTable) {
				
		List<Map<String, String >> credList = CredentialTable.asMaps();
		
		String Username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=my-account");
		A_Page = L_Page.doLogin(Username, password); //coming from feature file...linking with Feature File
	}

	@Given("User is on Accounts Page")
	public void user_is_on_accounts_page() {
		
		String title1 = A_Page.getAcctnPageTitle();
		System.out.println("Title of page is : " + title1);
		

	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		
		List<String> ExpectedSection = sectionsTable.asList();	
		System.out.println("Expected section list ==> " + ExpectedSection);
		
		List<String> ActualSection = A_Page.getAccountSctionList();
		System.out.println("Actual section list ==> " + ActualSection);
		
		Assert.assertTrue(ExpectedSection.containsAll(ActualSection));
		
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer ExpectedSecCount) {

		Assert.assertTrue(A_Page.getAccountSectionCount()== ExpectedSecCount);

	}

}

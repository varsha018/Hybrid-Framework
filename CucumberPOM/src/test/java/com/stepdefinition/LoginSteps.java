package com.stepdefinition;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private static String title;

	private LoginPage L_Page = new LoginPage(DriverFactory.getDriver()); // link with DRIVER FACTORY to get the driver

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		title = L_Page.getLoginPageTitle();
		System.out.println("Login Page title is ==> " + title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {

		Assert.assertTrue(L_Page.isForgotPasswordLinkPresent());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	L_Page.getUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		L_Page.getPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		L_Page.ClickOnLogin();
	}



}

package com.qa.opencart.baseclass;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.driverfactory.DriverFacto;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.productInfoPage;
import com.qa.opencart.pages.searchResultsPage;

public class BaseTest {
	public WebDriver driver;
	public DriverFacto df;
	public LoginPage loginpage;
	public Properties prop;
	public AccountPage accPage;
	public searchResultsPage searchRecPage;
	public productInfoPage productInfPage;
	public RegisterPage regPage;
	public SoftAssert softAssert;

	@BeforeTest
	public void setup() {
		df = new DriverFacto();
		prop = df.initProp();
		driver = df.initDriver(prop);
		System.out.println(" Login Page ****** 1 " + loginpage);
		this.loginpage = new LoginPage(driver);
		System.out.println(" Login Page ****** 2 " + loginpage);
		softAssert = new SoftAssert();
		// https://learngitbranching.js.org/
		// https://learngitbranching.js.org/
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}

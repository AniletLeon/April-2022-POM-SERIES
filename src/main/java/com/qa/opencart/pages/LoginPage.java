package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Appconstant;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private ElementUtil eleUtil;
	private By emailId = By.id("input-email");
	private By passWord = By.id("input-password");
	private By loginBotton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
	private By forgotpasswordlink = By.linkText("Forgotten Password");
	private By registerlink = By.cssSelector("#column-right > div > a:nth-child(2)");
	private By image = By.xpath("//*[@id=\"logo\"]/a/img");
	private By registerLink = By.linkText("Register");
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String loginPageTitle() {
		String title = eleUtil.waitForTitleToBe(Appconstant.LOGIN__PAGE_TITLE, Appconstant.MEDIUM_DEFAULT_TIME_OUT);
		System.out.println("login page title:  " + title);
		return title;
	}

	public String loginPageUrl() {
		String url = eleUtil.waitForUrl(Appconstant.SMALL_DEFAULT_TIME_OUT, Appconstant.LOGIN__PAGE_URL);
		System.out.println("login page URL:  " + url);
		return url;
	}

	public boolean isForgotpasswordExit() {
		return eleUtil.waitForElementPresence(forgotpasswordlink, Appconstant.SMALL_DEFAULT_TIME_OUT).isDisplayed();
	}

	public AccountPage doLogin(String userName, String pwd) {
		System.out.println("app creds..." + userName + ";" + pwd);
		eleUtil.doSendKeysWithWait(emailId, Appconstant.MEDIUM_DEFAULT_TIME_OUT, userName);
		eleUtil.doSendKeys(passWord, pwd);
		eleUtil.doClick(loginBotton);
//return eleUtil.waitForTitleToBe(Appconstant.ACCOUNT_PAGE_TITLE, Appconstant.SMALL_DEFAULT_TIME_OUT);
		return new AccountPage(driver);
	}

	public boolean isRegisterExit() {
		return eleUtil.waitForElementPresence(registerlink, Appconstant.SMALL_DEFAULT_TIME_OUT).isDisplayed();
	}

	public boolean isImageExit() {
		return eleUtil.waitForElementPresence(image, Appconstant.SMALL_DEFAULT_TIME_OUT).isDisplayed();
	}

	public searchResultsPage performSearch(String name) {
		AccountPage accpage = new AccountPage(driver);

		return accpage.doSearch(name);

	}

	public RegisterPage goToRegisterPage() {
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}

}

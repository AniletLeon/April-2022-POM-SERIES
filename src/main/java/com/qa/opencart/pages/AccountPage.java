package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Appconstant;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {
	private ElementUtil eleUtil;
	private By logoutlink = By.linkText("Logout");
	private By searchField = By.name("search");
	private By accPageHeader = By.cssSelector("div#content h2");
	private By searchIcon = By.cssSelector("div#search button");

	private WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtil = new ElementUtil(this.driver);
	}

	public String getAccountPageTitle() {
		String title = eleUtil.waitForTitleToBe(Appconstant.ACCOUNT_PAGE_TITLE, Appconstant.MEDIUM_DEFAULT_TIME_OUT);
		System.out.println("login page title:  " + title);
		return title;
	}

	public String gerAccountPageUrl() {
		String url = eleUtil.waitForUrl(Appconstant.SMALL_DEFAULT_TIME_OUT, Appconstant.ACCOUNT_PAGE_URL);
		System.out.println("login page title:  " + url);
		return url;
	}

	public boolean isLogOutLinkExit() {
		return eleUtil.waitForElementPresence(logoutlink, Appconstant.SMALL_DEFAULT_TIME_OUT).isDisplayed();

	}

	public boolean isSearchFieldExit() {
		return eleUtil.waitForElementPresence(searchField, Appconstant.SMALL_DEFAULT_TIME_OUT).isDisplayed();

	}

	public List<String> getAccountPageHeadList() {
		return eleUtil.getAllElementsTextList(accPageHeader, Appconstant.MEDIUM_DEFAULT_TIME_OUT);

	}

//commonPage Action
	public searchResultsPage doSearch(String productName) {
		System.out.println("Search for  " + productName);
		eleUtil.doSendKeysWithWait(searchField, 10, productName);
		eleUtil.doClick(searchIcon);
		return new searchResultsPage(driver);
	}

}

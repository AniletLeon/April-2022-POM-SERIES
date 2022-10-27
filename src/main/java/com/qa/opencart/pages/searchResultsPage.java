package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Appconstant;
import com.qa.opencart.utils.ElementUtil;

public class searchResultsPage {
	private ElementUtil eleUtil;

	By productCount = By.cssSelector("div.product-thumb");

	private WebDriver driver;

	public searchResultsPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtil = new ElementUtil(this.driver);
	}

	public int getSearchProductCount() {
		return eleUtil.waitForElementsToBeVisible(productCount, Appconstant.MEDIUM_DEFAULT_TIME_OUT).size();
	}

	public productInfoPage selectProduct(String productName) {
		By product = By.linkText(productName);
		eleUtil.doClick(product);
		return new productInfoPage(driver);
	}

}

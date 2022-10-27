package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.baseclass.BaseTest;

public class ProductSearchTest extends BaseTest {

	@BeforeClass
	public void prouuctSearchSetup() {
		accPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "mac book", "MacBook Pro" }, { "mac book", "MacBook Air" },
				{ "samsung", "Samsung SyncMaster 941BW" }

		};
	}

	@Test(dataProvider = "getProductData")
	public void prouuctSearchTest(String searchkey, String productname) {
		searchRecPage = accPage.doSearch(searchkey);
		productInfPage = searchRecPage.selectProduct(productname);
		String accProductHeaderName = productInfPage.getProductHeaderValue();
		Assert.assertEquals(accProductHeaderName, productname);
	}

	@DataProvider
	public Object[][] getProductInfoData() {
		return new Object[][] { { "mac book", "MacBook Pro", 4 }, { "mac book", "MacBook Air", 4 },
				{ "samsung", "Samsung SyncMaster 941BW", 1 }, { "iMac", "iMac", 3 } };
	}

	@Test(dataProvider = "getProductInfoData")
	public void prouuctImageCountTest(String searchkey, String productname, int imageCount) {
		searchRecPage = accPage.doSearch(searchkey);
		productInfPage = searchRecPage.selectProduct(productname);
		int accImageCount = productInfPage.getProductImageCount();
		Assert.assertEquals(accImageCount, imageCount);
	}

	@Test
	public void getProductDataTest() {
		searchRecPage = accPage.doSearch("mac book");
		productInfPage = searchRecPage.selectProduct("MacBook Pro");

		Map<String, String> accProductInfo = productInfPage.getProductInfo();

		softAssert.assertEquals(accProductInfo.get("Brand"), "Apple");
		softAssert.assertEquals(accProductInfo.get("Product Code"), "Product 18");
		softAssert.assertEquals(accProductInfo.get("Reward Points"), "800");
		softAssert.assertEquals(accProductInfo.get("Availability"), "In Stock");
		softAssert.assertEquals(accProductInfo.get("Productname"), "MacBook Pro");
		softAssert.assertEquals(accProductInfo.get("extprice"), "Ex Tax: $2,000.00");
		softAssert.assertEquals(accProductInfo.get("productprice"), "$2,000.00");

		softAssert.assertAll();

	}

}

package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.baseclass.BaseTest;
import com.qa.opencart.constants.Appconstant;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accSetup() {
		accPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void isLogoutLinkExitTest() {
		Assert.assertEquals(accPage.isLogOutLinkExit(), true);
	}

	@Test
	public void isAccountPageTitleTest() {
		Assert.assertEquals(accPage.getAccountPageTitle(), Appconstant.ACCOUNT_PAGE_TITLE);

	}

	@Test
	public void isAccountPageUrlTest() {
		Assert.assertEquals(accPage.gerAccountPageUrl(), Appconstant.ACCOUNT_PAGE_URL);
	}

	@Test
	public void isSearchFieldTest() {
		Assert.assertEquals(accPage.isSearchFieldExit(), true);
	}

	@Test
	public void isAccountPageHeaderListTest() {
		List<String> accPageHeaderActual = accPage.getAccountPageHeadList();
		System.out.println("This is actual header" + accPageHeaderActual);
		Assert.assertEquals(accPageHeaderActual, Appconstant.EXPECTED_ACCOUCT_HEADER_LIST);

	}

}

package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.baseclass.BaseTest;
import com.qa.opencart.constants.Appconstant;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic -100:Design the login")
@Story("US-101:Design login page")
public class LoginPageTest extends BaseTest {
	@Test
	@Description("Login page title test")
	@Severity(SeverityLevel.NORMAL)
	public void loginPageTitleTest() {
		String actTitle = loginpage.loginPageTitle();
		Assert.assertEquals(actTitle, Appconstant.LOGIN__PAGE_TITLE);

	}

	@Test
	public void loginPageUrlTest() {
		String actUrl = loginpage.loginPageUrl();
		Assert.assertEquals(actUrl.contains(Appconstant.LOGIN__PAGE_URL), true);
	}

	@Test
	public void forgotPasswordLinkExitTest() {
		Assert.assertEquals(loginpage.isForgotpasswordExit(), true);
	}

	@Test
	public void registerLinkExitTest() {
		Assert.assertEquals(loginpage.isRegisterExit(), true);
	}

	@Test
	public void imageExitTest() {
		Assert.assertEquals(loginpage.isImageExit(), true);
	}

	@Test
	public void loginTest() {
		accPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccountPageTitle(), Appconstant.ACCOUNT_PAGE_TITLE);
	}

}

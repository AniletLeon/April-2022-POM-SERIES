package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.baseclass.BaseTest;

public class RegisterTest extends BaseTest{
	@BeforeClass
	public void regSetup() {
		regPage=loginpage.goToRegisterPage();
	}
	@DataProvider
	public Object[][] getRegData() {
		return new Object[][] {
			{"anson11", "leo11", "ans1o@gmail.com","tanrt@123","34252667369", "yes"},
			{"anton11", "leo1", "1@gmail.com","tesrle1o@123","3425266764", "no"},
			{"leon1111", "lt1", "sd@1gmail.com","trt@123","342526365", "yes"}
		};
	}
	@Test(dataProvider="getRegData")
	public void userRefTest(String firstname,String lastname,String email, String phone, String password,String subscribe) {
		boolean suessflag=regPage.userRegisteration(firstname,lastname,email,phone, password,subscribe);
	Assert.assertEquals(suessflag, true);
	
	}

}

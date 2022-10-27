package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Appconstant;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	private ElementUtil eleUtil;
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By passwordconfirm = By.id("input-confirm");

	private By subscribeyes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeno = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");

	private By checkbox = By.name("agree");
	private By continuebutton = By.xpath("//input[@type='submit'and@value='Continue']");
	private By sussesmsg = By.cssSelector("div#content h1");
	private By logoutlink = By.linkText("Logout");
	private By registerlink = By.linkText("Register");

	public RegisterPage(WebDriver driver) {
		eleUtil = new ElementUtil(driver);

	}

	public boolean userRegisteration(String firstname, String lastname, String email, String phone, String password,
			String subscribe) {
		eleUtil.doSendKeysWithWait(this.firstname, Appconstant.MEDIUM_DEFAULT_TIME_OUT, firstname);
		eleUtil.doSendKeys(this.lastname, lastname);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, phone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.passwordconfirm, password);
		if (subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(this.subscribeyes);

		} else {
			eleUtil.doClick(this.subscribeno);
		}
		eleUtil.doClick(this.checkbox);
		eleUtil.doClick(this.continuebutton);
		String actsucessmsg = eleUtil.waitForElementVisible(this.sussesmsg, Appconstant.MEDIUM_DEFAULT_TIME_OUT)
				.getText();
		System.out.println("print sucess mesg========" + actsucessmsg);
		if (actsucessmsg.contains(Appconstant.REGIDTER_SUCCESS_MESSG)) {
			eleUtil.doClick(this.logoutlink);
			eleUtil.doClick(this.registerlink);

			return true;
		}
		return false;
	}

}

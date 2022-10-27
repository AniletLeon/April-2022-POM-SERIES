package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class Appconstant {
	public static final int SMALL_DEFAULT_TIME_OUT = 5;
	public static final int MEDIUM_DEFAULT_TIME_OUT = 10;
	public static final int LONG_DEFAULT_TIME_OUT = 20;

	public static final String LOGIN__PAGE_TITLE = "Account Login";
	public static final String LOGIN__PAGE_URL = "route=account/login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/account";

	public static final List<String> EXPECTED_ACCOUCT_HEADER_LIST = Arrays.asList("My Account", "My Orders",
			"My Affiliate Account", "Newsletter");

	public static final String PRODUCT_SEARCH__PAGE_URL = "https://naveenautomationlabs.com/opencart/index.php?route=product/search&search=macbook";
	public static final String REGIDTER_SUCCESS_MESSG = "Your Account Has Been Created!";

}

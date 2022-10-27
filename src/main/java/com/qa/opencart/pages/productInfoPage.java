package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.Appconstant;
import com.qa.opencart.utils.ElementUtil;

public class productInfoPage {

	private ElementUtil eleUtil;

	private WebDriver driver;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By pricingData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	
	private Map<String, String> productMap;
	
	public productInfoPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtil = new ElementUtil(this.driver);
	}

	public String getProductHeaderValue() {
		// By mainProduct=By.xpath("//h1[text()='");
		String productHeaderVal = eleUtil.doElementGetText(productHeader);

		System.out.println("productHeaderVal");
		return productHeaderVal;
	}

	public int getProductImageCount() {
		int imagescount = eleUtil.waitForElementsToBeVisible(productImages, Appconstant.SMALL_DEFAULT_TIME_OUT).size();
		System.out.println("images count" + imagescount);
		return imagescount;
	}

	public String isProductImagePageUrl() {
		String url = eleUtil.waitForUrl(Appconstant.SMALL_DEFAULT_TIME_OUT, Appconstant.PRODUCT_SEARCH__PAGE_URL);
		System.out.println("Product search page url:  " + url);
		return url;

	}
	
	public Map<String, String> getProductInfo() {
		productMap=new HashMap<String, String>();
		productMap.put("Productname", getProductHeaderValue());
		getproductMetaData();
		getmetaPriceList();
		System.out.println("============accproductInfo=========");
		productMap.forEach((k,v)->System.out.println(k+":" +v));
		
		
		
		
		
		return productMap;
		//Brand: Apple
				//	Product Code: Product 18
					//Reward Points: 800
				//	Availability: In Stock

		}
		
	
	//$2,000.00
//	Ex Tax: $2,000.00
	
	private void getproductMetaData() {
		List<WebElement> metaDataList=eleUtil.getElements(productMetaData);
		for(WebElement e:metaDataList) {
			String text=e.getText();
			String meta[]=text.split(":");
			String key=meta[0].trim();
String value=meta[1].trim();
productMap.put(key, value);
	}
	}
	private void getmetaPriceList() {
		List<WebElement> metaPriceList=eleUtil.getElements(pricingData);
		String productPrice=metaPriceList.get(0).getText().trim();	
		String productExtPrice=metaPriceList.get(1).getText().trim();	
		
		productMap.put("productprice", productPrice);
		productMap.put("extprice", productExtPrice);
		
	
	}

}

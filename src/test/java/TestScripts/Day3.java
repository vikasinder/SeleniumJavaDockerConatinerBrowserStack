package TestScripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Day1.BaseClass_BrowserSetup;
import PageObjectModel.AddToCartPage;
import PageObjectModel.HomePage;
import PageObjectModel.ShopPageObjects;
import Utilities.DriverFactory;

public class Day3 extends BaseClass_BrowserSetup{
	
	AddToCartPage addToCart;
	
	@Test
	public void Test1_checkClickThroughJavascript1() throws InterruptedException
	{
		ShopPageObjects day3=new ShopPageObjects(DriverFactory.getDriver());
		//addToCart=day3.selectItem();
		//addToCart.displayed();
		
		List<WebElement> total=	day3.totalLinks();
		
		
		for(WebElement ele:total)
		{
			System.out.println(ele.getText());
		}
	}

}

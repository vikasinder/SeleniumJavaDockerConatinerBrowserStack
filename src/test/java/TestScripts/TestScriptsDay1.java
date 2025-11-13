package TestScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Day1.BaseClass_BrowserSetup;
import PageObjectModel.AddToCartPage;
import PageObjectModel.HomePage;
import Utilities.DriverFactory;

public class TestScriptsDay1 extends BaseClass_BrowserSetup {
	
	
	private AddToCartPage addToCart;
	
	
	public void check()
	{
		System.out.println("Method check");
	}
		
		
	//getDriver()..coming here from browsersetup page
//		@Test
//		public void Test1_checkClickThroughJavascript() throws InterruptedException
//		{
//			JavaScriptFunctions day1=new JavaScriptFunctions(getDriver());
//			day1.clickLogin();
//		}
		
		
//		@Test
//		public void Test1_checkClickThroughJavascript1() throws InterruptedException
//		{
//			HomePage day1=new HomePage(DriverFactory.getDriver());
//			addToCart=day1.clickLogin();
//			addToCart.displayed();
//		
//		}
//		
		
		
}

package TestScripts;

import org.testng.annotations.Test;

import Day1.BaseClass_BrowserSetup;
import PageObjectModel.AlertsDemoPageObjects;
import PageObjectModel.DemoActionClass;
import PageObjectModel.DemoWindowHandler;
import Utilities.DriverFactory;

public class Day4TestAlert extends BaseClass_BrowserSetup {

	private Day4TestAlert()
	{
		System.out.println("Parent Class Constructor ");
	}
	
	public	Day4TestAlert(int k)
	{
		System.out.println("Parent Class Constructor :"+ k);
	}
	
//	@Test
//	public void simpleAlertTest() throws InterruptedException
//	{
//		AlertsDemoPageObjects demoAlert=new AlertsDemoPageObjects(DriverFactory.getDriver());
//		String actualValue=	demoAlert.clickAlertWithoutCancel();
//		Thread.sleep(2000);
//		System.out.println("Value apper on alert : "+ actualValue);
//	}
	
//	@Test
//	public void simpleWindowHandlerTest() throws InterruptedException
//	{
//		DemoWindowHandler demoWindow=new DemoWindowHandler(DriverFactory.getDriver());
//		demoWindow.clickWindowTab();
//		Thread.sleep(2000);
//	
//	}
	
	
	@Test
	public void simpleActionClassDoubleClick() throws InterruptedException
	{
		DemoActionClass demoWindow=new DemoActionClass(DriverFactory.getDriver());
		demoWindow.doubleClick();
		Thread.sleep(2000);
	
	}
}

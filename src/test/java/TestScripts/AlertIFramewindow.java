package TestScripts;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

import org.testng.annotations.Test;

import Day1.BaseClass_BrowserSetup;
import Utilities.DriverFactory;

public class AlertIFramewindow extends BaseClass_BrowserSetup {
	
	
	@Test
	public void actionClassCheck()
	{
		
		Actions action =new Actions(DriverFactory.getDriver());
		WebElement ele= DriverFactory.getDriver().findElement(By.xpath("//button[@id='alertButton']"));
		
		Action buildAction= action.doubleClick(ele).build();
		
		////Then later ON when you want to execute you can do buildAction.perform();
		buildAction.perform();
		
	// Build() : Is used to create the request
	// Perform Is used to Perform the request ..
		
		// You can do without using Build() 
		// we use build if we want to do the action later ON.. so we just build the request..and later in the code we can perform the operation
		// For that we have to use IAction Interface were we store the build() request..
		
		
	}
	
	@Test
	public void alertCheck()
	{
		try {
		
		Alert alert=DriverFactory.getDriver().switchTo().alert();
		
		//String textValue=driver.switchTo().alert().getText();
		String textValue=	alert.getText();
		alert.accept();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	
		//	driver.switchTo().alert().accept();
		
		
	}
	
	
	
//	public void sampleWindowHandler(WebDriver driver)
//	{
//		Set<String> windows=	driver.getWindowHandles();
//		
//		String currentWindow=	driver.getWindowHandle();
//		
//		for(String win:windows)
//		{
//			if(!win.equals(currentWindow))
//			{
//			driver.switchTo().window(win);
//			System.out.println("Your new window handle : " + win);
//			break;
//			}
//		}
//	}

}

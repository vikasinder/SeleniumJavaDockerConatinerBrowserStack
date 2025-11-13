package PageObjectModel;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Day1.ActionMethods;

public class AlertsDemoPageObjects {
	
	WebDriver driver;
	
	public AlertsDemoPageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//button[@id='alertButton']")
	WebElement simpleAlertWothoutCancel;
	
	
	public void clickAlertWithoutCancel() throws InterruptedException
	{
		ActionMethods action=new ActionMethods();
		action.javaScriptMethod(driver, simpleAlertWothoutCancel);
	    action.sampleWindowHandler(driver);
		
	}

}

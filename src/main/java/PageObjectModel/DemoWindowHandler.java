package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Day1.ActionMethods;

public class DemoWindowHandler {
	
	WebDriver driver;
	
	public DemoWindowHandler(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//button[@id='tabButton']")
	WebElement tabButton;
	
	
	public void clickWindowTab() throws InterruptedException
	{
		ActionMethods action=new ActionMethods();
		action.javaScriptMethod(driver, tabButton);
		action.sampleWindowHandler(driver);
		
	}


}

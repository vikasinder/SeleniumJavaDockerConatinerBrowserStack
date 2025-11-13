package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Day1.ActionMethods;

public class DemoActionClass {
	
WebDriver driver;
	
	public DemoActionClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//button[@id='doubleClickBtn']")
	WebElement simpleDoubleClick;
	
	
	public void doubleClick() throws InterruptedException
	{
		ActionMethods action=new ActionMethods();
		action.sampleWindowMouseDoublecLICK(driver, simpleDoubleClick);
	   
		
	}

}

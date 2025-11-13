package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Day1.ActionMethods;


	public class AddToCartPage {
		
		WebDriver driver;
		///Note all the Testcripts pages should inhertit from browsersetp class  ..not page classes
		
	 public AddToCartPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements( driver,this);
		 
	 }
	
	@FindBy(xpath="//span[text()='Add To Cart']")
	WebElement addToCartButton;
			
	public void displayed() throws InterruptedException
	{
		ActionMethods action=new ActionMethods();
		Boolean value=	action.verifyTextPageSource(driver, addToCartButton);
		System.out.println("Is Displayed :"+ value);
	} 

	 


}

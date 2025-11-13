package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Day1.ActionMethods;

public class ShopPageObjects {
	
	WebDriver driver;
	
	public ShopPageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[normalize-space(text())='BACCIANO, Taide']")
	WebElement baccinoTaideText;
	
	@FindBy(xpath="//div[normalize-space(text())='BACCIANO, Tomasso']")
	WebElement baccinoTommosaText;
	
	//@FindBy(xpath = "//a[normalize-space(text())='SHOP']")
	@FindBy(linkText = "SHOP")
	WebElement clickShop;
	
	
	    @FindBy(xpath = "//button")
		//@FindBy(linkText = "SHOP")
	    List<WebElement> allAnchorTagLinks;
		
	
//	public AddToCartPage selectItem() throws InterruptedException
//	{
//		ActionMethods action = new ActionMethods();
//		action.javaScriptMethod(driver, clickShop);
//		Thread.sleep(5000);
//		action.javaScriptMethod(driver, baccinoTaideText);
//		
//		return new AddToCartPage(driver);  //Returning object of Add To Cart page
//	}
	
//	public List<WebElement> totalLinks() throws InterruptedException
//	{
//		List<WebElement> totalAnchorTags=driver.findElements(By.xpath("//button"));
//		
//		
//		return totalAnchorTags;  //Returning object of Add To Cart page
//	}
	
	public List<WebElement> totalLinks() throws InterruptedException
	{
		//List<WebElement> totalAnchorTags=driver.findElements(By.xpath("//button"));
		
		
		return allAnchorTagLinks;  //Returning object of Add To Cart page
	}
	
	
	
}

package Day1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionMethods {
	
	public void javaScriptMethod(WebDriver driver, WebElement ele) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//js.executeScript("window.scrollBy(0,1500)", "");
		
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2200));
		
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		//AddToCartPage cartPage=new AddToCartPage();
		
		js.executeScript("arguments[0].click();", ele);		
	
//		String elementVisible=driver.findElement(By.xpath("//*[@id='auth-form-heading']")).getText();
//		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//	
//		//username.sendKeys("vikas_sharma1057@yahoo.com");
//		WebElement password=driver.findElement(By.id("pass"));
//		password.sendKeys("Vikas@1057");
//		Thread.sleep(2000);
//		WebElement clickButton= driver.findElement(By.xpath("//button[normalize-space(text()='Log In')]"));
//		
//		js.executeScript("arguments[0].click();",clickButton);
		
		
		
	//	js.executeScript("alert('Hello World!')");
		
		
		
		
	//	js.executeScript(null, null);
	
		//driver.quit();
	}

	public boolean verifyText(WebDriver driver, WebElement ele)
	{
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	        wait.until(ExpectedConditions.visibilityOf(ele));
	        return true;  // ✅ Element is visible
	    } catch (TimeoutException e) {
	        return false; // ❌ Element not visible within wait time
	    }
		
	}
	
	
	public boolean verifyTextPageSource(WebDriver driver, WebElement ele)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		
		String PageSource=driver.getPageSource();
		if (PageSource.contains(ele.getText())) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public String simpleAlertMethod(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		Alert alert=driver.switchTo().alert();
		
		//String textValue=driver.switchTo().alert().getText();
		String textValue=	alert.getText();
		// or we can do 
		alert.accept();
	
		//	driver.switchTo().alert().accept();
		
		return textValue;
	}
	
	public void sampleWindowHandler(WebDriver driver)
	{
		Set<String> windows=	driver.getWindowHandles();
		
		String currentWindow=	driver.getWindowHandle();
		
		for(String win:windows)
		{
			if(!win.equals(currentWindow))
			{
			driver.switchTo().window(win);
			System.out.println("Your new window handle : " + win);
			break;
			}
		}
	}
	
	
	public void sampleWindowMouseDoublecLICK(WebDriver driver,WebElement ele)
	{
		
//		Actions action =new Actions(driver);
//		action.doubleClick(ele).perform();
		
		
	// Build() : Is used to create the request
	// Perform Is used to Perform the 	
	}
	
	
	public void sampleMoveToElement(WebDriver driver,WebElement ele)
	{
		
		Actions action =new Actions(driver);
		action.moveToElement(ele).perform();
	}

	
	public void sampleDragAnddrop(WebDriver driver,WebElement SrcElement, WebElement targetElement)
	{
		
		Actions action =new Actions(driver);
		action.dragAndDrop(SrcElement,targetElement).perform();
	}
	

}

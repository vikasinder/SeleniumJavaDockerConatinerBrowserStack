package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Day1.ActionMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage
{

		
	WebDriver driver;
	
	public HomePage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}


	@FindBy(xpath="//a[normalize-space(text())='TESAURO']")
	WebElement shirtCategory;
	
	
	public AddToCartPage clickLogin() throws InterruptedException
	{
		ActionMethods action=new ActionMethods();
		action.javaScriptMethod(driver, shirtCategory);
		return new AddToCartPage(driver);
		
		
	}
	
//	<suite name="CrossBrowserTest" parallel="tests" thread-count="2"> This defines global parallelism for everything inside that suite  When we do suite level it is applied to all classes and methods inside that classes,
	//But if we want that Each test group then we can do  <test name="SmokeTests" parallel="classes" thread-count="2">..all the classes within
	//this test group only will run parallel, overriding suite level configuration
//	<listeners>
//		<listener class-name="Utilities.TestListner">
//		</listener>
//	</listeners>
//
//	  <test  name="ChromeTest" >
//	  <parameter name="browser" value="chrome"></parameter>
//		<classes>
//	 <class name="TestScripts.TestScriptsDay1"/>
//	   <class name="TestScripts.TestScriptsDay2"/>
//	 
//	    </classes>
//	  </test>
//	  
//	  <test  name="FireFoxTest" >
//	  <parameter name="browser" value="firefox"></parameter>
//		<classes>
//		    <class name="TestScripts.Day3"/>
//	    </classes>
//	  </test> <!-- Test -->
//	</suite> <!-- Suite -->

}

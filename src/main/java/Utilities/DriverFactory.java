package Utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	//For Multithreading tdriver gets individual value of driver instance..using set method at line 40
    // tdriver is a variable of type ThreadLocal class that store sepreate copy for each driver instance passed to It.
	

	 public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
	
	    
	 
	 public static synchronized WebDriver getDriver() {
	        return tdriver.get();
	    }

	 public static synchronized void setDriver(WebDriver driverInstance) {
	        tdriver.set(driverInstance);
	    }
	    
}

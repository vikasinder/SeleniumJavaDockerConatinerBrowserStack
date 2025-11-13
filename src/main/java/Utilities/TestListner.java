package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListner implements ITestListener {
	
	
	 public void onStart(ITestContext context) {
		 System.out.println("Test Execution Starts Here..");
			  }

	 public void onTestStart(ITestResult result) {
		 
		 System.out.println("Test Starts Here..");
		    // not implemented
		  }

		 
	 public void onTestSuccess(ITestResult result) {
		    
		 System.out.println("TestCase Successfully Passed");
		  }

	
	 public void onTestFailure(ITestResult result) {
		 System.out.println("TestCase Failed");
		    // not implemented
		  }

		 
	 public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

		
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

		
	 public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		
	

		
	 public void onFinish(ITestContext context) {
		    // not implemented
		  }
}

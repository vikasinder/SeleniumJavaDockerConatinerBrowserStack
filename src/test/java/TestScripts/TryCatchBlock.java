package TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

public class TryCatchBlock {
	
	@Test
	public void NotryCatchBlockCheck() throws ArithmeticException
	{
		int k= 10;
		int divide=k/0;
					
		// Even though you used throws ArithmeticException,
		// the compiler doesn’t care — as it unchecked exception it will stop the execution of this Test Only
		//	and will still crash at runtime unless you catch it manually
		
	}
	
	
//	Key: Uncaught exception stops the normal flow immediately.
	@Test
	public void tryCatchBlockCheck() throws ArithmeticException
	{
		int k= 10;
			try 
				{
					int divide=k/0;
				}
			catch (StaleElementReferenceException e) 
				{
					System.out.println("StaleElementReferenceException exception here");
				}
			catch (ArithmeticException e) 
				{
				System.out.println("ArithmeticException exception here");
				}
			
		
		// Even though you used throws ArithmeticException,
		// the compiler doesn’t care — it compiles fine,
		//	and will still crash at runtime unless you catch it manually
		
	}
	@Test
	public void tryCatchBlockCheckFinally() throws ArithmeticException
	{
		int k= 10;
			try 
				{
					int divide=k/0;
				}
			catch (StaleElementReferenceException e) 
				{
					System.out.println("StaleElementReferenceException exception here");
				}
			catch (ArithmeticException e) 
				{
					System.out.println("ArithmeticException exception here");
				}
			finally 
				{
				// This block will be executed , does not matter whether exception is there or not
			    	System.out.println("Finally Block");
				}
		
		// Even though you used throws ArithmeticException,
		// the compiler doesn’t care — it compiles fine,
		//	and will still crash at runtime unless you catch it manually
		
	}
}

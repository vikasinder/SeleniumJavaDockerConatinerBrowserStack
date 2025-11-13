package TestScripts;

import org.testng.annotations.Test;

public class Day5ParentChildRealtionship extends Day4TestAlert {

	public Day5ParentChildRealtionship()
	{
		super(10);
		System.out.println("Child Class Constructor ");
		
	}
	
	public void nameCheck() 
	{
//		TestScriptsDay1 check=new TestScriptsDay1();
//		check.check();
		
	}
	
	
	public static void nameCheck1() 
	{
		TestScriptsDay1 check=new TestScriptsDay1();
		check.check();

	}
	@Test
	public void checkParentChildRealtionship()
	{
		
	}
}

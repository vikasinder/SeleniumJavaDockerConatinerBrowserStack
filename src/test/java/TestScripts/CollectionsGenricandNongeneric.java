package TestScripts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import Day1.BaseClass_BrowserSetup;

public class CollectionsGenricandNongeneric extends BaseClass_BrowserSetup {
	
	// In Arrays And ArrayList we can use Index , as Items are in Indexing and Sorted Order But not with Set / Hashset
	
	@Test
	public void arrayCheck()
	{
	// Homogenous Value: Values of one type only
	int[] arr= {10,20,30};
	
	for(int i=0; i<arr.length; i++)
	{
		System.out.println("Value is :"+arr[i]);
	}
	
	}
	
	@Test
	public void arrayListCheck()
	{
	// Values of diffrent data types
		
	//UpCasting To parent class as List is parent of Arraylist class	
		List nonGeneric=new ArrayList();
		
		nonGeneric.add("Apple");
		nonGeneric.add("Banana");
		nonGeneric.add("Cherry");
		
		for(int i=0; i<nonGeneric.size(); i++)
		{
			System.out.println("Value is :"+ nonGeneric.get(i));
		}
		
		
		
	/////////////////////////////////////////////////////////////////////////////////////////
		ArrayList nonGeneric1=new ArrayList();
			
		nonGeneric1.add("Apple1");
		nonGeneric1.add("Banana1");
		nonGeneric1.add("Cherry1");
	
		for(int i=0; i<nonGeneric.size(); i++)
		{
			System.out.println("Value is :"+ nonGeneric1.get(i));
		}	
		
	////////////////////////////////////////////////////////////////////////////////////////////////	
		// Genric where <String> denotes <> placeholder and generic denotes by E in java and T in c#
		List<String> mylist=new ArrayList<String>();
	
	
		mylist.add("Apple2");
		mylist.add("Banana2");
		mylist.add("Cherry2");
		mylist.add("Angoor");
		
		
		mylist.sort(null);
		
		for(int i=0; i<mylist.size(); i++)
		{
			System.out.println("Value is :"+ mylist.get(i));
		}
	////////////////////////////////////////////////////////////////////////////////	
		List<Integer> mylist1=new ArrayList<Integer>();
		
		
		mylist1.add(100);
		mylist1.add(200);
		mylist1.add(300);
	
		for(Integer i : mylist1)
		{
			System.out.println("Value is :"+ i);
		}
		
		///////////////////////////////////////////////////////////////////////
		///HASH SET
		///
		// Unordered Values : Not Like List 
		// No Duplicated Allowed
		
		
		// Genric means you just have to change the type: It works for all One common way to Intiazlize
		
		//UpCasting To parent class as SET  is parent of Hashset class	
		Set<String> setCheck1Generic=new HashSet<>();
	    	
		setCheck1Generic.add("Set Value 1");
		setCheck1Generic.add("Set Value 2");
		setCheck1Generic.add("Set Value 3");
		setCheck1Generic.add("Set Value 3");
		
		// Unordered So Indexing cannot be Used to Get the Values
		
		for(String setValuesString : setCheck1Generic)
		{
			System.out.println("Value is :"+ setValuesString );
		}
	/////////////////////////////////////////////////////////////////////////////	
		
		Set<Integer> setCheck2Generic=new HashSet<>();
    	
		setCheck2Generic.add(101);
		setCheck2Generic.add(201);
		setCheck2Generic.add(301);
		setCheck2Generic.add(301);
		
		
		for(Integer setValuesInteger : setCheck2Generic)
		{
			System.out.println("Value is :"+ setValuesInteger );
		}
		
	//////////////////////////////////////////////////////////////////////////////	
		
		Set setCheck1NonGeneric=new HashSet();
    	
		setCheck1NonGeneric.add("Set Value 11");
		setCheck1NonGeneric.add("Set Value 21");
		setCheck1NonGeneric.add("Set Value 31");
		setCheck1NonGeneric.add("Set Value 31");
		
		// Why Object as Object is parent of all datatypes , so we can use Object if we are not sure of datatype that is there 
		for(Object setValuesStringNongeneric1 : setCheck1NonGeneric)
		{
			System.out.println("Value is :"+ setValuesStringNongeneric1 );
		}
		
	///////////////////////////////////////////////////////////////////////	
		HashSet setCheck2NonGeneric=new HashSet();
    	
		setCheck2NonGeneric.add("Set Value 111");
		setCheck2NonGeneric.add("Set Value 211");
		setCheck2NonGeneric.add("Set Value 311");
		setCheck2NonGeneric.add("Set Value 311");
		
		// Why Object as Object is parent of all datatypes , so we can use Object if we are not sure of datatype that is there 
		// As its Not Genric Type : we have not mentioned any DataType
		
		for(Object setValuesStringNongeneric2 : setCheck2NonGeneric)
		{
			System.out.println("Value is :"+ setValuesStringNongeneric2 );
		}
//		for(int i=0; i<setCheck2NonGeneric.size(); i++)
//		{
//			System.out.println("Value is :"+ setCheck2NonGeneric);
//		}
		
//		You can’t use a traditional index-based for loop
//
//		Because a HashSet:
//
//		Has no fixed order
//
//		Does not store elements by index
//
//		So this will never work:
//
//		for (int i = 0; i < setCheck2NonGeneric.size(); i++) {
//		    System.out.println(setCheck2NonGeneric.get(i)); // ❌ No .get() method
//		}
	
	}

	
}

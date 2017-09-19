
import java.util.*;
import java.lang.*;
import java.io.*;

class ABHandler
{
	String finalString = "";
	boolean validStringVerified = false;

	public int getNumberOfABPairs(String testStr)
	{	
		int mergedCount = 0;
		
		//Return -1 for invalid String
		if(!validStringVerified) {	
			for(int i=0; i < testStr.length(); i++) 
			{
				if(testStr.charAt(i) != 'A' && testStr.charAt(i) != 'B') 
				{
					return -1;
				}
			}
			validStringVerified = true;
		}
		
		//Base case
		if(testStr.length() == 2) 
		{
			if(testStr.equals("AB"))
			{
				return 1;
			}
			else 
			{
				return 0;
			}
		}
		
		if(testStr.charAt(0) == 'B')
		{
			return getNumberOfABPairs(testStr.substring(1));
		}
		else
		{
			for(int i = 1; i < testStr.length(); i++) 
			{
				if(testStr.charAt(i) == 'B') 
				{
					mergedCount ++;
				}	
			}
			
			return mergedCount + getNumberOfABPairs(testStr.substring(1));
		}
	}
}

public class ABProblem
{
	public static void main (String[] args) throws java.lang.Exception
	{

		String testStr = "BAABBABAAB";
		if(args != null && args.length > 0) {	
			testStr = args[0];
		}
				
		ABHandler abObj = new ABHandler();
		System.out.println("The value of K in the String " + testStr + " is " + abObj.getNumberOfABPairs(testStr));
	}
	
}

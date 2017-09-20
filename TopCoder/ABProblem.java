
import java.util.*;
import java.lang.*;
import java.io.*;

class ABHandler
{
	String finalString = "";
	boolean validStringVerified = false;

	public int getNumberOfABPairs(String testStr)
	{	
		int KCount = 0;
		int aCount = 0;
		
		/* Code with nested for loops
		for(int i=0; i < testStr.length() - 1 ; i++)
		{
			if(testStr.charAt(i) == 'A') 
			{	
				for(int j= i+1; j < testStr.length(); j++)
				{
					if(testStr.charAt(j) == 'B')
					{
						KCount ++;
					}
				}
			}
		}*/

		// Following code uses only 1 for loop
		for(int i = 0; i < testStr.length(); i++) 
		{
			if(testStr.charAt(i) == 'A')
			{
				aCount ++; // One more A in the string					   	
			}
			else if(testStr.charAt(i) == 'B')
			{
				KCount += aCount;   // KCount will increase by the number of previous As in the string
			}	
		}
		
		return KCount;
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

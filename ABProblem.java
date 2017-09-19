/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	String finalString = "";
	static boolean validStringVerified = false;
	
	public static int testString(String testStr) 
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
			return testString(testStr.substring(1));
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
			
			return mergedCount + testString(testStr.substring(1));
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		String testStr = "BAABBABAAB";
		System.out.println("The value of K in the String " + testStr + " is " + testString(testStr));
	}
	
	
}

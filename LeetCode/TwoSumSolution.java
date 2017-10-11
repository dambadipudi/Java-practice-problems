/**
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
*
* You may assume that each input would have exactly one solution, and you may not use the same element twice.
*
* Example:
* Given nums = [2, 7, 11, 15], target = 9,
*
* Because nums[0] + nums[1] = 2 + 7 = 9,
* return [0, 1].
*
*
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public int[] twoSum(int[] nums, int target) {
    /* Code with O(n^2) complexity
		int numbersSum = 0;
    int next = 0;
		for(int cur=0; cur < nums.length; cur++) {
      next = cur+1;
    	while(next < nums.length) {
     		numbersSum = nums[cur] + nums[next];
     		if(numbersSum == target) {
       		return new int[]{cur, next};
     		}
     		next ++;
    	}
    }
	  return new int[]{};
		*/
		
		// Following code with O(n) because I used HashMap
		HashMap<Integer,Integer> otherNumberMap = new HashMap<Integer,Integer>();
        
    for(int cur=0; cur < nums.length; cur++) {
      int possibleOtherNumber = target - nums[cur];
      if(otherNumberMap.containsKey(possibleOtherNumber)) {
				return new int [] {otherNumberMap.get(possibleOtherNumber), cur};
      } else {
      	//Store the current number and index for use in future iterations
      	otherNumberMap.put(nums[cur], cur);
      }        
    }
		//return empty array if the loop doesn't return anything
		return new int [] {};
    }
}

public class TwoSumSolution
{
	public static void main (String[] args) throws java.lang.Exception
	{
    Solution solObj = new Solution();
		System.out.println("The values are "+Arrays.toString(solObj.twoSum(new int[]{3, 2, 1}, 5)));
	}
}

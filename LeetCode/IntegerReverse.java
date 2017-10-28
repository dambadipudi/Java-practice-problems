class Solution {
  /* Reverse digits of an integer.

		Example1: x = 123, return 321
		Example2: x = -123, return -321

		The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows
	*/
	public int reverse(int x) {
        	int reverseX = 0;
		int tempX = x;
		int MaxIntByTen = Integer.MAX_VALUE / 10;
		int MaxIntModTen = Integer.MAX_VALUE % 10;
		int MinIntByTen = Integer.MIN_VALUE / 10;
		int MinIntModTen = Integer.MIN_VALUE % 10;
		while (!(tempX / 10 == 0 && tempX % 10 == 0)) {
			if((x >= 0 && reverseX <= MaxIntByTen) ||
			   (x < 0 && reverseX >= MinIntByTen)) {
				if((x >= 0 && reverseX == MaxIntByTen && tempX % 10 > MaxIntModTen) ||
				   (x < 0 && reverseX == MinIntByTen && tempX % 10 < MinIntModTen)) {
					//Overflow of last digit 
					return 0;
					
				} else {
					reverseX = reverseX * 10 + tempX % 10;
					//System.out.println(reverseX);
				}
			}
			else {
				//Overflow of integer	
				return 0;	
			}
			tempX = tempX / 10;
		}
		return reverseX;
   	}
}

public class IntegerReverse
{
	public static void main (String[] args) throws java.lang.Exception {
    Solution solObj = new Solution();
	  System.out.println(solObj.reverse(2073847412));
	}
}

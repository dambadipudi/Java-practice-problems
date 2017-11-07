// Determine whether an integer is a palindrome. Do this without extra space.

class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
		if(x < 0) {
	            return false;
	        }

		//Store reverse of the number until you reach half
		int reverseHalf = 0;
		int noOfDigits = 0;
		int tempX = x;
		while(tempX > 0 && noOfDigits < Math.floor(Math.log10(tempX))) { //No of digits of reverse number should be atleast same as no of digits of original number
			noOfDigits ++;
			reverseHalf = reverseHalf * 10 + tempX % 10;			
			tempX = tempX / 10;
		}
		if(noOfDigits == Math.floor(Math.log10(tempX))) { //For odd digits tempX has an extra digit
			tempX = tempX / 10; 			
		}
		return (tempX == reverseHalf);
    }
}

class IntegerPalindrome {
    public static void main(String [] args) {
        Solution solObj = new Solution();
        System.out.println(solObj.isPalindrome(100021));
    } 
 }

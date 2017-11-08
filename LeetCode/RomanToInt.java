// Given a roman numeral, convert it to an integer.
// Input is guaranteed to be within the range from 1 to 3999.

class Solution {
    static class RomanMap {
        static int returnInt(char c) {
        	switch(c) {
                case 'I' : return 1; 
                case 'V' : return 5; 
                case 'X' : return 10;
                case 'L' : return 50;
                case 'C' : return 100;
                case 'D' : return 500;
                case 'M' : return 1000;
                default : return 0;
			}
        }
    }    
    
    // This is faster than using the HashMap
    public int romanToInt(String s) {
        int result = 0, i = 0;
	    for(; i < s.length() - 1; i++) {
            int numberToAdd = Solution.RomanMap.returnInt(s.charAt(i));
            if(numberToAdd < Solution.RomanMap.returnInt(s.charAt(i+1))) {
                result = result - numberToAdd;
            }
            else {
                result = result + numberToAdd;
            }      
        }
        result = result +  Solution.RomanMap.returnInt(s.charAt(i)); //Add the last number
        return result;
    }
    
    public int romanToInt2(String s) {
        	//Start from left to right. If the next numeral is smaller, than add this numeral
	        // If the next numeral is larger, then subtract this numeral
	        Map<Character,Integer> romanToIntMap = new HashMap<Character,Integer>();
	        romanToIntMap.put('I',1);
	        romanToIntMap.put('V',5);
	        romanToIntMap.put('X',10);
	        romanToIntMap.put('L',50);
	        romanToIntMap.put('C',100);
	        romanToIntMap.put('D',500);
	        romanToIntMap.put('M',1000);
	        
	        int result = 0;
	        
	        for(int i = 0; i < s.length(); i++) {
			      if(romanToIntMap.containsKey(s.charAt(i))) {	
			      	int numberToAdd = romanToIntMap.get(s.charAt(i));
			      	if(i == s.length() - 1) {
					      result = result + numberToAdd;
			      	} 
              else if(romanToIntMap.containsKey(s.charAt(i+1))) {
					      if(numberToAdd < romanToIntMap.get(s.charAt(i+1))) {
						      result = result - numberToAdd;
	              }
	            	else {
	                result = result + numberToAdd;
	            	}
				      }
				      else {
					      break;
				      } 		
			      }
			      else {
				      break;
			      }
	        }
	        return result;
	}

}

public class RomanToInt {
  public static void main(String [] args) {
    Solution solObj = new Solution();
    solObj.romanToInt("XIV");
  }
}

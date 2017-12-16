class Solution {
  
  public boolean isValid(String s) {
    Deque<Character> charStack = new ArrayDeque<Character>();
	  for(int i = 0; i < s.length(); i++) {
		  switch(s.charAt(i)) {
			  case '(' : 	charStack.push(')');
				  	break;	
		  	case '[' : 	charStack.push(']');
			  		break;
  			case '{' : 	charStack.push('}'); 
	  				break;
	  		case ')' :
	  		case ']' : 
	  		case '}' : 	if(charStack.size() != 0 && charStack.pop() == s.charAt(i)) {
		  				break;
			  		}
				  	else {
					  	return false;
					  }
		  }
		 
    }
    if(charStack.size() == 0) {
	    return true;
	  } 
	  else {
		  return false;
	  }    
  }
}

class StringValidity {
  public static void main(String args[]) {
      //Test cases
		  String [] bracketStrings = new String [] {"", "(", ")", "[", "]", "{", "}", "()", "[]", "{}", "({})", "({[]})", "(]", "({)}"};
		   for(int i = 0; i < bracketStrings.length; i++) {
			    System.out.println("String " + bracketStrings[i] + "'s validity is " + solObj.isValid(bracketStrings[i]));
		   }
   }
}

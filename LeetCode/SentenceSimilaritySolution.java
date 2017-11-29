/*
Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.

For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.

However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
*/

class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        int lengthOfSentence = words1.length;
        if(lengthOfSentence != words2.length) {
            return false;
        }
        
        //Create a hashmap with all the possible similar words from pairs array
        Map<String, ArrayList<String>> allSimilarWords = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < pairs.length; i++) {
            if(allSimilarWords.containsKey(pairs[i][0])) {
                allSimilarWords.get(pairs[i][0]).add(pairs[i][1]);
                
            } else {
                ArrayList<String> arr = new ArrayList<String>();
                arr.add(pairs[i][1]);
                allSimilarWords.put(pairs[i][0],arr);
            }
            if(allSimilarWords.containsKey(pairs[i][1])) {
                allSimilarWords.get(pairs[i][1]).add(pairs[i][0]);
                
            } else {
                ArrayList<String> arr = new ArrayList<String>();
                arr.add(pairs[i][0]);
                allSimilarWords.put(pairs[i][1],arr);
            }
        }
        
        int currentWord = 0;
        while(currentWord < lengthOfSentence) {
            if(!words1[currentWord].equals(words2[currentWord])) {
                if(!allSimilarWords.containsKey(words1[currentWord])) {
                    return false;
                }
                else if(!allSimilarWords.get(words1[currentWord]).contains(words2[currentWord])) {
                    return false;
                } 
                else {
                    currentWord++;
                }  
            }
            else {
                currentWord++;
            }            
        }
                        
        //If it has come here then all words are similar - return true
        return true;
    }
}

class SentenceSimilaritySolution {
  public static void main(String [] args) {
    Solution solObj = new Solution();
    solObj.areSentencesSimilar(["great","acting","skills"],["fine","drama","talent"],[["great","fine"],["acting","drama"],["skills","talent"]]);
   }
}

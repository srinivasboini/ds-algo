package dsa.arrays.bruteforce;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.longestSubstring("abcabcbb"));
        System.out.println(l.longestSubstring("bbbb"));
    }


    public int longestSubstring(String input){
        int maxLen = Integer.MIN_VALUE;
        int size = input.length();

        for(int i=0; i<size; i++){
            for(int j=i; j<size; j++){
                String subStr = input.substring(i, j);
                if(!hasRepeatedChars(subStr)){
                   maxLen = Math.max(maxLen, subStr.length());
                }
            }
        }
        return maxLen;
    }

    private boolean hasRepeatedChars(String subInput){
        HashSet<Character> set = new HashSet<>();
        for(Character ch : subInput.toCharArray()){
            if(set.contains(ch)){
                return true;
            }else{
                set.add(ch);
            }
        }
        return false;
    }
}

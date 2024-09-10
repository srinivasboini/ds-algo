package dsa.arrays.sliding;

import java.util.HashMap;
import java.util.Map;

public class LongestKUniqueCharacterSubstring {

    public static void main(String[] args) {
        LongestKUniqueCharacterSubstring l = new LongestKUniqueCharacterSubstring();
        System.out.println(l.longestSubString("abcdefgggh", 5));
    }

    //abcdefgh  k=
    public int longestSubString(String s, int k){
        int size = s.length();
        int uniqueCharCount = 0;
        Map<Character, Integer> chars = new HashMap<>();
        int len;
        int maxLen = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MIN_VALUE;

        while(end < size){

            Character currentChar = s.charAt(end);
            chars.merge(currentChar, 1, Integer::sum);

            if(chars.get(currentChar) == 1){
                uniqueCharCount = uniqueCharCount + 1;
            }

            if(uniqueCharCount == k){
                len = end - start + 1;
                maxLen = Math.max(min, len);
            }
            //shrinking
            else if(uniqueCharCount > k){

                while(start < end && uniqueCharCount > k){
                    currentChar = s.charAt(start++);
                    chars.merge(currentChar, -1, Integer::sum);

                    if(chars.get(currentChar) == 0){
                        uniqueCharCount = uniqueCharCount -1;
                    }
                }
            }

            end ++;
        }



        return maxLen;
    }
}
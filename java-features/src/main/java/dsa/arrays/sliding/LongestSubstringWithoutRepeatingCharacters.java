package dsa.arrays.sliding;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * 	•	Input: s = "abcabcbb"
 * 	•	Output: 3
 * 	•	Explanation: The answer is "abc", with a length of 3.
 * 	•	Input: s = "bbbbb"
 * 	•	Output: 1
 * 	•	Explanation: The answer is "b", with a length of 1.
 *
 * Approach: Sliding Window
 *
 * We will use a sliding window approach where we expand and contract the window dynamically while maintaining a set of the characters currently in the window.
 *
 * 	1.	Initialize two pointers: start and end, both starting at the beginning of the string.
 * 	2.	Use a HashSet: to store the characters currently in the window.
 * 	3.	Expand the window: by moving end pointer, and check if the character is already in the set.
 * 	•	If it’s not in the set, add it and update the length of the longest substring.
 * 	•	If it’s already in the set, remove characters from the start pointer until that character can be added again.
 * 	4.	Track the maximum length: by comparing the size of the current window with the previously recorded maximum size.
 */
public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {

        //System.out.println(lengthOfLongestSubstring("abcccaa"));
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstringRev2("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstringRev2("bbbb"));
    }

//    private static int lengthOfLongestSubstring(String s) {
//        int length = s.length();
//
//        int ans =0;
//        int start = 0;
//        int end = 0;
//
//        Set<Character> chars = new HashSet<>();
//
//        while(start < length && end < length){
//
//            //get the current character
//            Character currentChar = s.charAt(end);
//
//            if(chars.contains(currentChar)){
//                chars.remove(s.charAt(start));
//                start++;
//            }else{
//                chars.add(currentChar);
//                end++;
//                ans = Math.max(ans, end - start); //update the max length
//
//            }
//
//        }
//
//        return ans;
//    }

    //"abcccaa"
    public int lengthOfLongestSubstringRev2(String input){
        int maxLen = Integer.MIN_VALUE;
        int size = input.length();
        int start=0, end = 0;
        int len = 0;

        Set<Character> set = new HashSet<>();
        while(end < size){
            char currentChar = input.charAt(end);

            if(set.contains(currentChar)){
                while(start < end && set.contains(currentChar)){
                    char charFromStart = input.charAt(start++);
                    set.remove(charFromStart);
                }
            }

            set.add(currentChar);
            len = end - start + 1 ;
            maxLen = Math.max(maxLen, len);
            end ++ ;
        }

        return maxLen == Integer.MIN_VALUE ? -1 : maxLen;


    }

}

package dsa.arrays.sliding;

import java.util.HashMap;
import java.util.Map;

public class LongestKUniqueCharacterSubstring {

    public static void main(String[] args) {
        LongestKUniqueCharacterSubstring l = new LongestKUniqueCharacterSubstring();
        //System.out.println(l.longestSubString("abcdefgggh", 5));

        System.out.println(l.longestSubStringRev2("abcdefgggh", 5));
        System.out.println(l.longestSubStringRev2("aaabbb", 3));
    }

    //abcdefgh  k=
//    public int longestSubString(String s, int k){
//        int size = s.length();
//        int uniqueCharCount = 0;
//        Map<Character, Integer> chars = new HashMap<>();
//        int len;
//        int maxLen = 0;
//        int start = 0;
//        int end = 0;
//        int min = Integer.MIN_VALUE;
//
//        while(end < size){
//
//            Character currentChar = s.charAt(end);
//            chars.merge(currentChar, 1, Integer::sum);
//
//            if(chars.get(currentChar) == 1){
//                uniqueCharCount = uniqueCharCount + 1;
//            }
//
//            if(uniqueCharCount == k){
//                len = end - start + 1;
//                maxLen = Math.max(min, len);
//            }
//            //shrinking
//            else if(uniqueCharCount > k){
//
//                while(start < end && uniqueCharCount > k){
//                    currentChar = s.charAt(start++);
//                    chars.merge(currentChar, -1, Integer::sum);
//
//                    if(chars.get(currentChar) == 0){
//                        uniqueCharCount = uniqueCharCount -1;
//                    }
//                }
//            }
//
//            end ++;
//        }
//
//        return maxLen;
//    }


    //"abcdefgggh"  k 2
    private int longestSubStringRev2(String input, int k){
        int size = input.length();
        int maxLen = Integer.MIN_VALUE;
        int start = 0, end =0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(end < size){
            //get character from end index;
            Character currentChar = input.charAt(end);
            //add to map with count
            map.merge(currentChar, 1, Integer::sum);

            //check for count now
            if(map.size() == k){
                //extract the length
                len = end - start + 1;
                maxLen = Math.max(maxLen, len);
            }
            //shrink phase
            else if(map.size() > k){
               //move start pointer towards end
                while(start < end && map.size() > k){
                    currentChar = input.charAt(start++);
                    map.merge(currentChar, -1, Integer::sum);

                    if(map.get(currentChar) == 0){
                        map.remove(currentChar);
                    }
                }
            }

            //expand to right
            end++;
        }


        return maxLen == Integer.MIN_VALUE ? -1 : maxLen;
    }

}
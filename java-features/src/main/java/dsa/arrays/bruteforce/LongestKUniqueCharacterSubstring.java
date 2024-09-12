package dsa.arrays.bruteforce;

import java.util.HashSet;

public class LongestKUniqueCharacterSubstring {

    public static void main(String[] args) {
        LongestKUniqueCharacterSubstring l = new LongestKUniqueCharacterSubstring();
        System.out.println(l.longestSubString("abcdefgggh", 5));
        System.out.println(l.longestSubString("aaabbb", 3));
    }

    private int longestSubString(String input, int k) {
        int maxLength = Integer.MIN_VALUE;
        for(int i=0; i<input.length(); i++){
            for(int j=i; j<input.length(); j++){
                String sub = input.substring(i, j);
                if(hasKUniqueElements(sub, k)){
                    maxLength = Math.max(maxLength, sub.length());
                }
            }
        }
        return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
    }

    private boolean hasKUniqueElements(String subInput, int k){
        HashSet<Character> set = new HashSet<>();
        for(Character ch : subInput.toCharArray()){
            set.add(ch);
        }
        return set.size() == k;
    }
}

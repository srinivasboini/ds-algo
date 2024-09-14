package dsa.arrays.bruteforce;

import java.util.HashSet;
import java.util.Set;

public class AnagramOccurances {

    public static void main(String[] args) {
        AnagramOccurances a = new AnagramOccurances();
        System.out.println(a.findAnagramsIn("orfabcfortestroff", "for"));
    }


    public int findAnagramsIn(String input, String pattern){
        int count =0;
        int size = input.length();
        //prepare a hashset of pattern chars.
        Set<Character> set = new HashSet<>();
        for(Character character : pattern.toCharArray()){
            set.add(character);
        }

        //extract all substrings from input
        for(int i=0; i<size; i++){
            for(int j=i; j<size; j++){
                String subInput = input.substring(i, j);
                if(subInput.length() == set.size() && isAnagram(subInput, set)){
                    count++;
                }
            }
        }

        return count;
    }


    private boolean isAnagram(String subInput, Set<Character> pattern){
        for(Character character: subInput.toCharArray()){
            if(!pattern.contains(character)){
                return false;
            }
        }
        return true;
    }
}

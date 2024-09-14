package dsa.arrays.sliding;

import java.util.Arrays;

public class AnagramOccurances {


    public static void main(String[] args) {
        AnagramOccurances a = new AnagramOccurances();
        System.out.println(a.findAnagramsIn("orfabcfortestroff", "for"));
    }


    //orfabcfortestroff   for
    public int findAnagramsIn(String input, String pattern){
        int count = 0;
        int size=input.length();
        //build pattern char array
        int[] patternArray = new int[26];   //s - o(26)
        for(int i=0; i<pattern.length(); i++){
            int index = pattern.charAt(i) - 97 ;   //ascii of char a is 97
            patternArray[index]++ ;
        } //o(m)

        //process the first window
        int k = pattern.length();
        int[] inputArray = new int[26]; //s - o(26)
        for(int i=0; i<k; i++){
            int index = input.charAt(i) - 97;
            inputArray[index]++;
        }//o(m)

        if(Arrays.equals(patternArray, inputArray)){//o(26)
            count++;
        }

        //process remaining windows
        for(int i=1; i<=size-k; i++){
            //previous index
            int removeIndex = input.charAt(i-1) - 97;
            int addIndex = input.charAt(i+k-1) - 97;
            inputArray[removeIndex]--;
            inputArray[addIndex]++;

            if(Arrays.equals(inputArray, patternArray)){
                count++;
            }

        }//o(n-m)

        //o(m) + o(m) + o(n-m) * o(26)  -> o(m) + o(n) * 1
        //o(m+n);
        return count;
    }
}

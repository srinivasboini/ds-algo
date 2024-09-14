package dsa.arrays.bruteforce;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.findTwoSumIndices(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum.findTwoSumIndices(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum.findTwoSumIndices(new int[]{3, 3}, 6)));
    }

    //[2,7,11,15]  target 9
    public int[] findTwoSumIndices(int[] input, int target){
        int size = input.length;
        for(int i=0; i<size-1; i++){
            for(int j=i+1; j<size; j++){
                if(input[i] + input[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("no indices found");

    }
}

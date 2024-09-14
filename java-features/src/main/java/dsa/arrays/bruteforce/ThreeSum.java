package dsa.arrays.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.findThreeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    //[-1,0,1,2,-1,-4]
    List<List<Integer>> findThreeSum(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        int size=arr.length;
        for(int i=0; i<=size-3; i++){
            for(int j=i+1; j<size; j++){
                for(int k=j+1; k<size; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }

        return result;

    }
}

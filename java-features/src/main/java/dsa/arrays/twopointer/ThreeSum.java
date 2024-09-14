package dsa.arrays.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.findThreeSums(new int[]{-1,0,1,2,-1,-4}));

    }

    //[-1,0,1,2,-1,-4]
    List<List<Integer>> findThreeSums(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // O(n logn)
        int start, end;
        for(int i=0; i<=arr.length-3; i++){ // O(n-2)
            start = i+1;
            end = arr.length-1;
            while(start<end){ //O(n)

                if(arr[i] + arr[start] + arr[end] == 0){
                    result.add(Arrays.asList(arr[i], arr[start], arr[end]));
                    end--;
                }
                else if(arr[i] + arr[start] + arr[end] > 0){
                    end--;
                }else{
                    start++;
                }
            }

        }
        return result;

    }
}

package dsa.arrays.sliding;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaxElementInSubArray {

    public static void main(String[] args) {
        MaxElementInSubArray maxElementInSubArray = new MaxElementInSubArray();
        maxElementInSubArray.findMax(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4);
        maxElementInSubArray.findMaxTreemap(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4);

    }


    //Array: [8, 5, 10, 7, 9, 4, 15, 12, 90, 13] k=4
    public void findMax(int[] arr, int k){
        int size = arr.length;
        for(int i=0; i<= size - k; i++){
            int max = arr[i];

            for(int j=1; j<k; j++){
                if(arr[i+j] > max){
                    max = arr[i+j];
                }
            }
            System.out.print(max+ " ");
        }


    }

    //Array: [8, 5, 10, 7, 9, 4, 15, 12, 90, 13] k=4
    public void findMaxTreemap(int[] arr, int k){
        int size = arr.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        System.out.println();

        //process first window
        for(int i=0; i<k; i++){
            treeMap.put(arr[i], i);
        }

        System.out.print(treeMap.firstKey() + " ");

        //process remaining windows
        for(int i=1; i<=size-k; i++){
            treeMap.remove(arr[i-1]);
            treeMap.put(arr[i+k-1], arr[i+k-1]);
            System.out.print(treeMap.firstKey() + " ");
        }
    }
}

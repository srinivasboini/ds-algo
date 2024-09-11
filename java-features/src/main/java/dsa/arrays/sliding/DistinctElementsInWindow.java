package dsa.arrays.sliding;

import java.util.*;

public class DistinctElementsInWindow {

    public static void main(String[] args) {
        DistinctElementsInWindow inWindow = new DistinctElementsInWindow();
        int[] result = inWindow.countDistinct(new int[]{1,3,4,4,5,5,5,7}, 3);
        System.out.println(Arrays.toString(result));

        result = inWindow.countDistinctOptimized(new int[]{1,3,4,4,5,5,5,7}, 3);
        System.out.println(Arrays.toString(result));
    }

        //{1,3,4,4,5,5,6,7}  k= 3
    public int[] countDistinct(int[] arr, int k ){
        int size = arr.length;
        Set<Integer> set = new HashSet<>();
        int[] result = new int[size-k+1];

        for(int i=0; i<= size-k ; i++ ){
            set.clear();
            for(int j=i; j<= i+k-1; j++){
                set.add(arr[j]);
            }
            result[i] = set.size();
        }

        return result;
    }

    //{1,3,4,4,5,5,6,7}  k= 3
    public int[] countDistinctOptimized(int[] arr, int k ){
        int size = arr.length;
        int[] result = new int[size-k+1];
        Map<Integer, Integer> map = new HashMap<>();

        //process first window
        for(int i=0; i<k; i++){
            map.merge(arr[i], 1, Integer::sum);
        }
        result[0] = map.size();

        //process the remaining windows
        for(int i=1; i<=size-k; i++ ){ // size-k the outer bound
            //remove the previous one and add the next element
            map.merge(arr[i-1], -1, Integer::sum);//remove previous
            map.merge(arr[i+k-1], 1, Integer::sum);//add next one
            map.entrySet().removeIf(entry -> entry.getValue() == 0);
            result[i] = map.size();
        }
        return result;
    }
}

package dsa.arrays.sliding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumberInSubArray {

    public static void main(String[] args) {
        FirstNegativeNumberInSubArray firstNegativeNumberInSubArray = new FirstNegativeNumberInSubArray();

        int[] result = firstNegativeNumberInSubArray.negativeNumbersBF(new int[]{-8, 2, 3, -6, 10,-15}, 3);
        System.out.println(Arrays.toString(result));

        result = firstNegativeNumberInSubArray.negativeNumbersOptimized(new int[]{-8, 2, 3, -6, 10,-15}, 3);
        System.out.println(Arrays.toString(result));
    }

    //A[] = {-8, 2, 3, -6, 10} // k=3
    public int[] negativeNumbersBF(int[] n, int k){
        int size = n.length;
        int[] result = new int[size-k+1];

        for(int i=0; i<=size-k; i++){
            for(int j=i; j<=i+k-1; j++){
                if(n[j] < 0){
                    result[i] = n[j];
                    break;
                }
            }

        }

        return result;
    }

    //A[] = {-8, 2, 3, -6, 10,-15} // k=3
    public int[] negativeNumbersOptimized(int[] n, int k){
        int size = n.length;
        int[] result = new int[size-k+1];

        Queue<Integer> queue = new LinkedList<>();
        //go through first window and add to queue
        for(int i=0; i<k; i++){
            if(n[i] <0){
                queue.offer(n[i]);
            }
        }
        result[0] = queue.isEmpty() ? 0 : queue.peek();


        //slide the window
        for(int i=1; i<=size-k; i++){
            int previousIndex = i-1;
            int nextIndex = i+k-1;

            //remove the previous one
            if(n[previousIndex] < 0 ){
                queue.poll();
            }

            if(n[nextIndex] < 0){
                queue.offer(n[nextIndex]);
            }

            result[i] = queue.isEmpty() ? 0 : queue.peek();
        }

        return result;


    }


}

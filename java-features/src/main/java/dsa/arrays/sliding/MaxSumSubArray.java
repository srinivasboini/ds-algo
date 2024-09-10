package dsa.arrays.sliding;


import java.util.List;

/**
 * Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
 *
 * Input  : arr[] = {100, 200, 300, 400}, k = 2
 * Output : 700
 *
 * Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
 * Output : 39
 * We get maximum sum by adding subarray {4, 2, 10, 23} of size 4.
 *
 * Input  : arr[] = {2, 3}, k = 3
 * Output : Invalid
 * There is no subarray of size 3 as size of whole array is 2.
 */
public class MaxSumSubArray {

    public static void main(String[] args) {
        MaxSumSubArray sumSubArray = new MaxSumSubArray();
        sumSubArray.maxSum(3, new int[]{100, 200, 300, 400, 500});

    }

    //arr[] = {100, 200, 300, 400}   //k 2
    // arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4   next index is 4  total 9 i+k
    public Integer maxSum(int k, int[] n){
        int size = n.length;
        int sum = 0; int maxSum=0;

        //find the first window sum
        for(int i=0; i<size && i<k ;i++){
            sum = sum + n[i];
        }
        System.out.println("sum of first k elements "+sum);
        maxSum = sum;

        for(int i=1; i<=size-k; i++ ){
            sum = sum - n[i-1] + n[i+k-1];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println("max sum of k elements "+maxSum);
        return maxSum;

    }
}

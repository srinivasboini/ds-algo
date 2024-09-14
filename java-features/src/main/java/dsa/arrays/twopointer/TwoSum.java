package dsa.arrays.twopointer;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.findTwoSumSorted(new int[]{17,2,5,7,11}, 18)));
    }

    //[17,2,5,7,11]
    int[] findTwoSumSorted(int[] nums, int target){
        int[] copyArr = Arrays.copyOf(nums, nums.length);
        //[2,5,7,11,17]
        //define two pointers start, end
        Arrays.sort(copyArr); //O(nlogn) tc
        int start=0;
        int end=copyArr.length-1;
        int num1=0; int num2=0;

        while(start < end){//o(n)
            if(copyArr[start] + copyArr[end] == target){
                num1=copyArr[start];
                num2=copyArr[end];
                break;
            }else if(copyArr[start] + copyArr[end] > target){
                end--;
            }else{
                start++;
            }

        }

        //get the original indexes of num1 and num2 from original arr.
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){//0(n)
            if(nums[i] == num1){
                result[0] = i;
            }
            if(nums[i] == num2){
                result[1] = i;
            }
        }

        return result;
    }
}

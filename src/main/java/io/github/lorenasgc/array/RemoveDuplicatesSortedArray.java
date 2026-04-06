package io.github.lorenasgc.array;

import java.util.Arrays;

/* Exercise: Remove duplicates from a sorted array
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element
appears only once. The relative order of the elements should be kept the same.
Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique elements k.
The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can
be ignored.
 */

/* Big O of the implemented solution
Linear time complexity O(n) for looping once through array
Constant space complexity O(1) for only using variables and modiying the array in-place
 */

public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(nums);
        System.out.println("k = " + k);
        System.out.println(Arrays.toString(nums));
    }

    //Two pointer method: one to overwrite (k) and another to compare values (i)
    public static int removeDuplicates(int[] nums) {
        // The first element at index 0 is always unique
        int k = 1;
        for(int i = 1; i < nums.length; i++){
            //We have to compare whether the current value is the same as the previous one.
            //We don't move k unless i finds a unique value
            if (nums[i] != nums[i - 1]){
                nums[k] = nums[i]; // Store the unique value at index k
                k++; //And move k to the next index
            }
        }
        return k;
    }
}

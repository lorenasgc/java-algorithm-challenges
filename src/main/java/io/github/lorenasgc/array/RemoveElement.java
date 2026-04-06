package io.github.lorenasgc.array;

import java.util.Arrays;

/* Exercise: Remove an element from Array in-place
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements
may be changed. Then return the number of elements in nums which are not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining
elements of nums are not important as well as the size of nums.
Return k.
 */

/* Big O of the implemented solution
Linear time complexity O(n) for looping once through array
Constant space complexity O(1) for only using variables
 */

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int k;
        k = removeElement(nums, val);
        System.out.println(Arrays.toString(nums));
        System.out.println("k = " + k);
    }

    //Two pointer method: one (i) reads the values and another (k) rewrites
    public static int removeElement(int[] nums, int val){
        int k = 0; //Pointer that writes

        //i runs through the array
        for(int i = 0; i < nums.length; i++){
            //if [i] is NOT equal to val, [k] gets rewritten as [i] and then it moves on to the next index
            if (nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

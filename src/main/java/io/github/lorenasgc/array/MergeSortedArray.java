package io.github.lorenasgc.array;

import java.util.Arrays;

/* EXERCISE: MERGE SORTED ARRAYS
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */

/*Big O Analysis for implemented solution
Time Complexity: O(m + n) (Linear). We loop through both arrays from back to front just once.
Space Complexity: O(1) (Constant space). We haven’t created any new arrays; we’ve modified nums1 in-place using just
    three int variables.
*/

public class MergeSortedArray {
    public static void main(String[] args) {
        int [] nums1 = {1, 2, 3, 0, 0, 0};
        int [] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
    //Since the arrays are already SORTED, we start from the end of both arrays to check which is higher and insert or move accordingly
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //We need 3 pointers: p=last valid element of nums1, p1=last value of nums1 and p2=last valid element of num2
        int p = m + n - 1; //The end o the total length o num1 to accommodate num2
        int p1 = m - 1; //Where the actual values of num1 end
        int p2 = n - 1; //End of num2

        //while there are still elements left in nums2
        while (p2 >= 0){
            //if there are still elements in num1 AND num1 is higher than num2
            if (p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
            }else {
                //if num2 is higher or equal to num1, or there are no more values in num1
                nums1[p] = nums2[p2];
                p2--;
            }
            //We always move the insertion pointer one step back (left)
            p--;
        }
    }
}

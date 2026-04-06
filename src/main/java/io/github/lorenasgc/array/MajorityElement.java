package io.github.lorenasgc.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Exercise: Find the majority element in an array
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always
exists in the array.
Example 1:
Input: nums = [3,2,3]
Output: 3
 */

/* Big O of the implemented solutions
    First solution: HashMap with frequency as value:
        Linear time O(n) for looping through the array once.
        Linear space O(n) because we are storing the elements and their counts in a HashMap.
    Second solution: Boyer-Moore Majority Voting Algorithm
        Linear time O(n) for looping through the array once.
        Constant space O(1) because we are not using extra memory.
 */

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,2,1,1,2,1};
        int majority = majorityAlgorithm(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("Majority = " + majority);
    }

    //Store values in HashMap with value as the key and its frequency as the value
    public static int majorityElement(int[] nums) {
        int count;
        int majority = 0;
        Map<Integer, Integer> numElements = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            //Assigns it 1 the first time, or adds 1 to the existing count
            count = numElements.getOrDefault(nums[i], 0) + 1;
            numElements.put(nums[i], count); //Store it in the HashMap
            if(count > nums.length / 2){ //Inside the loop, we check to see if the condition to win is met
                majority = nums[i];
                return majority; //Early return. If we find the majority, we stop the loop
            }
        }
        // The exercise states there will always be majority, but just in case, we throw an exception
        throw new IllegalArgumentException("No majority found in the array");
    }

    //Boyer-Moore Majority Voting Algorithm
    //We do not have to check whether the votes comply with > n/2 since the exercise rules state that majority always exists
    public static int majorityAlgorithm (int[] nums){
        //Does NOT tell you how many times the number appears; it states who the winner is after the adding and subtracting of votes
        int votes = 0;
        //First candidate to win majority
        int candidate = nums[0];
        for(int i = 0; i < nums.length; i++){
            // Fase 1: if the current candidate has 0 votes, we make the next index the new candidate
            if(votes == 0){
                candidate = nums[i];
            }
            //Fase 2: if i equals candidate, we add one vote, if not, we deduct one
            if (nums[i] == candidate) {
                votes++;
            } else {
                votes--;
            }
        }
        return candidate;
    }
}

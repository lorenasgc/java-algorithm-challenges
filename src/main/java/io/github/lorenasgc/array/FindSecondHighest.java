package io.github.lorenasgc.array;

public class FindSecondHighest {

    public static void main(String[] args) {
        int[] nums = {10, 1, 5, 24, 30, 45, 17, 3, 40};
        System.out.println(findSecondHighest(nums));

    }

    public static Integer findSecondHighest(int[] nums) {
        //Case 1: check i the array is empty or has less than 2 values
        if(nums == null || nums.length < 2){
            System.out.println("Either the array is empty or has less than 2 values");
            return null;
        }

        //Big O: space complecity O(1) because we only need 2 extra variables
        //if we put 0 it woudn't take into account negative numbers
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        //Big O: time complexity O(n) because we run once through a loop
        for (int num : nums){
            //Corner case 2: if the new value is higher than our highest value, we assign it
            if(num > highest){
                secondHighest = highest; //first the second-highest get the current highest value
                highest = num;
            //Corner case 3: the num is lower than our highest but higher than our second-highest
            } else if (num > secondHighest && num != highest) {
                secondHighest = num;
            }
        }
        //Corner case 4: if all the values are the same
        if (secondHighest == Integer.MIN_VALUE) {
            System.out.println("All the values are the same");
            return null;
        }
        return secondHighest;
    }

}

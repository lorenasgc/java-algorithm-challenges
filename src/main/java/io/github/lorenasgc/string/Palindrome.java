package io.github.lorenasgc.string;

/*
Exercise: Valid Palindrome
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric
characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
 */

/*
Big O of the implemented solution:
Linear time complexity O(n) because we only loop once through the String.
Constant space complexity O(1) because we avoid creating a new String by converting the characters inside the loop as we compare them.
If we had used .toLowerCase before looping through the String, as Strings are immutable, we would have created a new one, turning
space complexity to O(n).
 */
public class Palindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        //String s = "race a car";
        boolean result = isPalindrome(s);
        System.out.println(result);

    }

    public static boolean isPalindrome (String s){
        //We need 2 pointers: one at the beginning of the String and another at the end to compare them.
        int i = 0;
        int k = s.length() - 1;
        //It's best to use a while loop for this scenario, and we must make sure to add the security measure i<k to avoid out-of-bounds error
        while(i < k){
            //if the pointer is not a letter or digit, it moves on to the next index, and it must do so while a letter or digit is not found
            while (i < k && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (i < k && !Character.isLetterOrDigit(s.charAt(k))){
                k--;
            }
            // If at any point the values of the pointers are different, we do an early return
            //Always check for negative results inside the loop to avoid false true
            //To avoid created a new String and turning space complexity from O(1) to O(n), we convert each character inside the loop as we compare
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(k))){
                return false;
            }
            i++;
            k--;
        }
        return true;
    }
}

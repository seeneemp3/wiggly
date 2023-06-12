package leetcode_codewars;

import java.util.Arrays;

/*
You are given a positive integer array nums.
The element sum is the sum of all the elements in nums.
The digit sum is the sum of all the digits (not necessarily distinct) that appear in nums.
Return the absolute difference between the element sum and digit sum of nums.
Note that the absolute difference between two integers x and y is defined as |x - y|.

Example 1:

Input: nums = [1,15,6,3]
Output: 9
Explanation:
The element sum of nums is 1 + 15 + 6 + 3 = 25.
The digit sum of nums is 1 + 1 + 5 + 6 + 3 = 16.
The absolute difference between the element sum and digit sum is |25 - 16| = 9.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Explanation:
The element sum of nums is 1 + 2 + 3 + 4 = 10.
The digit sum of nums is 1 + 2 + 3 + 4 = 10.
The absolute difference between the element sum and digit sum is |10 - 10| = 0.*/

public class lc2535 {
    public static int differenceOfSum(int[] nums) {
     /*
     ______-Крутое решение, жаль что не мое___________
        int s1=0;
        int s2=0;
        for(int n:nums){
            s1+=n;
            while (n>0){
                s2+=n%10;
                n/=10;
            }
        }
        return s1-s2;
____________а вот моее дальше_________________________
        */
        int sum2 = 0;
        StringBuilder sb = new StringBuilder();
        for (int a : nums) sb.append(a);
        for (char c : sb.toString().toCharArray()) sum2 += Character.getNumericValue(c);
        return Arrays.stream(nums).sum() - sum2;

    }

    public static void main(String[] args) {
        System.out.println(differenceOfSum(new int[]{1, 2, 3, 14}));

    }
}

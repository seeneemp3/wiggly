package leetcode_codewars;

import java.util.HashMap;
import java.util.Map;

/*169. Majority Element

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/
public class lc169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 2){
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        lc169 lc169 = new lc169();
        System.out.println(lc169.majorityElement(new int[] {2,2,1,1,1,2,2}));
    }
}

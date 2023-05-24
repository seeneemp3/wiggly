package leetcode_codewars;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
Return the sorted array.

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 */
public class lc1636 {
    //static int [] nums = {-53,-53,52,52,52,52,-53,-53,52,-53,52,52,52,-53,52,52,-53,52,-53,52,-53,52,52,52,52,52,52,52,52,52,-53,52,-53,52,-53,52,52,52,-53,-53,52,-53,52,52,52,52,-53,-53,-53,-53,-53,52,52,-53,52,-53,52,52,52};
    static int [] nums = {2,3,1,3,2};
    public static int[] frequencySort(int[] nums) {

        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : Arrays.stream(nums).distinct().toArray()){
            int count=0;
            for (int j : nums){
                if (i==j) count++;
            }
            hm.put(i,count);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(hm);

        Map <Integer,ArrayList<Integer>> hm2 = new HashMap<>();
        hm.forEach((k,v) -> {
            if (hm2.get(v) == null){
                hm2.put(v, new ArrayList<>());
                hm2.get(v).add(k);
            }else {
                hm2.get(v).add(k);
            }
        });

        //hm2.forEach((k,v) -> v.sort( (a, b) -> b - a));

        var al = new ArrayList<Map.Entry<Integer,ArrayList<Integer>>>();
        hm2.entrySet().forEach(al::add);
        al.sort(Comparator.comparingInt(Map.Entry::getKey));

        System.out.println("al "+al);

        System.out.println(hm2);

        ArrayList <Integer> lis = new ArrayList<>();

        al.forEach(s -> {
            var k = s.getKey();
            var v = s.getValue();
            v.sort((a, b) -> b - a);
            for (int i = 0; i <v.size(); i++) {
                for (int j = 0; j <k; j++) {
                    lis.add(v.get(i));
                }
            }
        });


        return lis.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

}

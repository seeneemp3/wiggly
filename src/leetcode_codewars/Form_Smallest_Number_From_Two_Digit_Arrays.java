package leetcode_codewars;
//    Given two arrays of unique digits nums1 and nums2, return the smallest number that contains at least one digit from each array.
//
//    Example 1:
//
//    Input: nums1 = [4,1,3], nums2 = [5,7]
//    Output: 15
//    Explanation: The number 15 contains the digit 1 from nums1 and the digit 5 from nums2. It can be proven that 15 is the smallest number we can have.

import java.lang.reflect.Array;
import java.util.*;

//    Example 2:
//
//    Input: nums1 = [3,5,2,6], nums2 = [3,1,7]
//    Output: 3
//    Explanation: The number 3 contains the digit 3 which exists in both arrays.
public class Form_Smallest_Number_From_Two_Digit_Arrays {

    public static void main(String[] args) {
        int [] nums1 = {4,1,3};
        int [] nums2 = {3,1,7};

        List <Integer> arr1 = new ArrayList<>();
        ArrayList <Integer> arr2 = new ArrayList<>();

        for (int n : nums1) arr1.add(n);
        for (int n : nums2) arr2.add(n);

        Collections.sort(arr1);
        Collections.sort(arr2);

        Integer in = Integer.min(
                Integer.parseInt(arr1.get(0).toString() + (arr2.get(0)).toString()),
                Integer.parseInt(arr2.get(0).toString() + (arr1.get(0)).toString()) ) ;

        ArrayList <Integer> repeat = new ArrayList<>();

        Set<Integer> set = new HashSet<>(arr1);

        for (int j = 0; j < arr2.size(); j++){
            if(!set.add(arr2.get(j))){
                repeat.add(arr2.get(j));
            }
        }

        //System.out.println(repeat);

        if (repeat.size()!=0){
            in = repeat.get(0);
        }

        String a = "12";
        a.toString();
        System.out.println(in);
    }





}

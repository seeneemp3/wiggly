package leetcode_codewars;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array {
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
        int sum2=0;
        StringBuilder sb=new StringBuilder();
        for(int a:nums) sb.append(a);
        for (char c:sb.toString().toCharArray()) sum2+= Character.getNumericValue(c);
        return Arrays.stream(nums).sum()-sum2;

    }

    public static void main(String[] args) {
        System.out.println(differenceOfSum(new int[]{1,2,3,14}));

    }
}

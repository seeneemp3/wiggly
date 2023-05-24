package leetcode_codewars;

public class Max_Consecutive_Ones {

    static int findMaxConsecutiveOnes(int[] nums)
    {
        int count=0;
        int max=0;

        for(int n:nums)
        {
            count=n==1 ? count+1 : 0;
            max=Math.max(count,max);
        }
        System.gc();
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
        System.out.println(Math.pow(10,5));
    }
}

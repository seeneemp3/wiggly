package leetcode_codewars;

public class Alternating_Digit_Sum {
    public static int alternateDigitSum(int n) {
    int sum=0;
    char [] a=Integer.toString(n).toCharArray();
        for (int i = 0; i <a.length; i++) {
            if (i % 2 == 0) {
                sum +=Character.getNumericValue(a[i]) ;
            } else sum -= Character.getNumericValue(a[i]);
        }

    return sum;
    }
    public static void main(String[] args) {
        System.out.println(alternateDigitSum(521) );


    }
}

package leetcode_codewars;

class sum_of_digits {

    /*______Условие_________

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.*/

    /* охуеть какое решение

    class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        else if(num % 9 == 0) return 9;
        else return num % 9;
    }
}
     */



    public static int addDigits(int b) {
        int a;
        char[] ch;
    do {
        a=0;
       ch = Integer.toString(b).toCharArray();
        for (char x : ch) {
            a += Character.getNumericValue(x);
        }
        b = a;
    }while(Integer.toString(b).length()> 1);
        return b;
    }


        public static void main (String[]args){
            System.out.println((2%3));

        }
    }

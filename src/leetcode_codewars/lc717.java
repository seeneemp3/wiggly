package leetcode_codewars;

/*We have two special characters:
The first character can be represented by one bit 0.
The second character can be represented by two bits (10 or 11).
Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.

Example 1:

Input: bits = [1,0,0]
Output: true
Explanation: The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.

Example 2:

Input: bits = [1,1,1,0]
Output: false
Explanation: The only way to decode it is two-bit character and two-bit character.
So the last character is not one-bit character.
*/



public class lc717 {
    public static boolean isOneBitCharacter(int[] bits) {
        /*if (bits[0]==1&&bits.length==1) return false;
        if (bits[0]==0&&bits.length==1) return true;
        if (bits[bits.length-1]==1) return false;

        for (int i = 0; i <bits.length; i++) {
            if(bits[i]==1&&(bits[i+1]==1 ||bits[i+1]==0)){
                if (i+1== bits.length-1) return false;
                i++;
            }

        }
        return true;*/


        int ones = 0;
        //интересное решение которое рассматривает последние значения ...0,1,0 или ...1,1,0
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0 ; i--) {
            System.out.println("[i]="+i);
            ones++;
        }
        System.out.println(ones);
        return ones % 2 == 0;


    }

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1,1,1,0,0,1,1,0}));
    }
}

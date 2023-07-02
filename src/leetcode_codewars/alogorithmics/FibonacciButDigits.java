package leetcode_codewars.alogorithmics;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciButDigits {

    static Scanner sc = new Scanner(System.in);
    static int n =  sc.nextInt();

    public static void main(String[] args) {
        System.out.println(doFibonacci());
    }

    public static byte doFibonacci() {
        int count = n;

        byte a = 0;
        byte b = 1;
        byte x;

        while (count - 1  > 0){

            x = (byte) (((a % 10) + (b % 10)) % 10);
            a = b;
            b = x;

            count--;
        }

        return b;
    }




}

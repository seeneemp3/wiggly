package leetcode_codewars.alogorithmics;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTable {

       static Scanner sc = new Scanner(System.in);
       static short n = (short) sc.nextInt();
       static int[] arr = new int[n + 1];



    public static int doFibonacci() {
        arr[0] = 0;
        arr[1] = 1;

        for (short i = 2; i < arr.length; i++){
            arr [i] = arr [i - 1] + arr[i - 2];
            System.out.println("arr["+i+"] = " + arr [i]);
        }

        System.out.println(Arrays.toString(arr));


        return arr[arr.length -1];
//        int a = 0;
//        int b = 1;
//        for (int i = 0; i < arr.length; i++) {
//            a += b;
//            b = a - b;
//        }
//        return b;
    }

    public static void main(String[] args) {

        System.out.println(doFibonacci());


    }
}

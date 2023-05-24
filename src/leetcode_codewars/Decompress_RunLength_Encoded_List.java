package leetcode_codewars;

import java.util.ArrayList;
import java.util.Arrays;

public class Decompress_RunLength_Encoded_List {
    //Decompress_RunLength_Encoded_List a=new Decompress_RunLength_Encoded_List();



    public int[] decompressRLElist(int[] nums) {
        int arr[]=null;
        ArrayList <Integer>al=new ArrayList<>();
        for (int i = 0; i <nums.length; i+=2) {
            arr=new int[nums[i]];
            Arrays.fill(arr, nums[i+1]);
            for(int a:arr) al.add(a);
        }
        arr=new int[al.size()];
        int x=0;
        for (Integer i:al) {
            arr[x] = i;
            x++;
        }
        System.gc();
        return arr;
    }

    public static void main(String[] args) {
        Decompress_RunLength_Encoded_List d=new Decompress_RunLength_Encoded_List();
        System.out.println(Arrays.toString(d.decompressRLElist(new int[]{1, 2, 3, 4})));
    }

}

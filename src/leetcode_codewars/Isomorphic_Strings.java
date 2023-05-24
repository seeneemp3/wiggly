package leetcode_codewars;
//Given two strings s and t, determine if they are isomorphic.
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//All occurrences of a character must be replaced with another character while preserving
//the order of characters. No two characters may map to the same character, but a character may map to itself.
//Input: s = "egg", t = "add"
//Output: true
//Input: s = "foo", t = "bar"
//Output: false

import com.sun.source.tree.BreakTree;

import java.util.HashMap;

public class Isomorphic_Strings {
    // Мое решение, которое занимает много времени и проверяет каждый с каждым
    //________________________________________________________________________
//    public static boolean isIsomorphic(String s, String t) {
//        return extracted(s).equals(extracted(t));
//    }
//
//    private static String extracted(String s) {
//        StringBuilder sb=new StringBuilder();
//        char ch[]= s.toCharArray();
//        for (char cha: ch){
//            for (char c : ch) {
//                sb.append((cha == c ? 1 : 0));
//            }
//        }return sb.toString();
//    }
//

    // Решение с использованием HashMap
    public static String transform (String str){
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int a = 0; a < str.length(); ++a) {
            char ch = str.charAt(a);
            if (!hm.containsKey(ch)) {
                hm.put(ch, a);
            }
            sb.append(Integer.toString(hm.get(ch)));
sb.append(" ");
        } return sb.toString();
    }

    public static boolean isIsomorphic(String s, String t) {
        System.out.println(transform(s)+"\n"+transform(t));
        System.out.println(transform(s).equals(transform(t)));
        return transform(s).equals(transform(t));
    }


//            012345678910111213141516171819202122232425210
//            012345678910111213141516171819202122232425210



    public static void main (String[]args){
String s="abcdefghijklmnopqrstuvwxyzva";
String b="abcdefghijklmnopqrstuvwxyzck";
        isIsomorphic(s, b);

    }

    }

package leetcode_codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/*
* Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
* */
public class lc383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aab","baa")); ;
    }
    public static boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : magazine.toCharArray()) hm.put(ch, hm.getOrDefault(ch, 0) + 1);

        for(char ch : ransomNote.toCharArray()){
            if(!hm.containsKey(ch) || hm.get(ch) < 1) return false;
            hm.put(ch, hm.get(ch) - 1);
        }
        return true;
       /* ArrayList<String> al1 = new ArrayList<>(Arrays.asList(magazine.split("")));
        StringBuilder sb = new StringBuilder();


        for (String str : ransomNote.split("")){
            Iterator <String> it1 = al1.listIterator();
            while (it1.hasNext()){
                String a = it1.next();
                if (a.equals(str)){
                    it1.remove();
                    sb.append(str);
                    break;
                }
            }
        }
        System.out.println(sb);

        return sb.length() == ransomNote.length();*/
    }
}

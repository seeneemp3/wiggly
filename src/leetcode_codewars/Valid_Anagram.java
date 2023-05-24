package leetcode_codewars;
//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//        Example 1:
//
//        Input: s = "anagram", t = "nagaram"
//        Output: true
//        Example 2:
//
//        Input: s = "rat", t = "car"
//        Output: false
public class Valid_Anagram {
    /*static boolean isAnagram (String s, String t) {
        if (s.equals(t)) return true;
        if (s.length() != t.length()) return false;
        return check(s, t);

    }
    static boolean check (String s, String t){
        ArrayList<String> al = new ArrayList<>(Arrays.asList(s.split("")));
        for (String str : t.split("")){
            Iterator <String> it = al.listIterator();
            while (it.hasNext()){
                String a = it.next();
                if (a.equals(str)){
                    it.remove();
                    break;
                }
            }
        }
        return al.size() == 0;
    }
    public static void main(String[] args) {
        isAnagram("mamamia","ammamia");
    }*/

    public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) return false;

    var a = s.toCharArray();
    var b = t.toCharArray();

    Arrays.sort(a);
    Arrays.sort(b);

    for (int i = 0; i < a.length; i++){
        if (a[i] != b[i]) return false;
    }
    return true;
    }
}

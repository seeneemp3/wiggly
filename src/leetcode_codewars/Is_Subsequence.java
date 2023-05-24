package leetcode_codewars;
import java.util.*;
//Is Subsequence
// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
// A subsequence of a string is a new string that is formed from the original string by
// deleting some (can be none) of the characters without disturbing the relative positions
// of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
public class Is_Subsequence {
/*    public static boolean met(String s, String t) {for(int i = 0; i < s.length(); i++)
    {
        int currentIndex = -1;
        if((currentIndex = t.indexOf(s.charAt(i))) < 0)
            return false;
        t = t.substring(currentIndex+1);
        System.out.println(t);
    }
        return true;
    }

 */

/*    public boolean isSubsequence(String s, String t) {
        int si = 0;
        if (s.length() < 1)
            return true;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(si) == t.charAt(i))
                si++;
            if (si == s.length())
                return true;
        }return false;
    }
    */


    public static void main(String[] args) {

    }

    }


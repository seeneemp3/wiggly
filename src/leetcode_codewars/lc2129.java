package leetcode_codewars;
/*
You are given a string title consisting of one or more words separated by a single space, where each word consists of English letters. Capitalize the string by changing the capitalization of each word such that:
If the length of the word is 1 or 2 letters, change all letters to lowercase.
Otherwise, change the first letter to uppercase and the remaining letters to lowercase.
Return the capitalized title.

Example 1:
Input: title = "capiTalIze tHe titLe"
Output: "Capitalize The Title"
Explanation:
Since all the words have a length of at least 3, the first letter of each word is uppercase, and the remaining letters are lowercase.

Example 2:
Input: title = "First leTTeR of EACH Word"
Output: "First Letter of Each Word"
Explanation:
The word "of" has length 2, so it is all lowercase.
The remaining words have a length of at least 3, so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.

Example 3:
Input: title = "i lOve leetcode"
Output: "i Love Leetcode"
Explanation:
The word "i" has length 1, so it is lowercase.
The remaining words have a length of at least 3, so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.*/

public class lc2129 {
    public String capitalizeTitle(String title) {
        StringBuilder sb;
        StringBuilder sb2=new StringBuilder();
        for(String a:title.toLowerCase().split(" ")){
            System.out.println(a);
            if(a.length()>2){
                sb=new StringBuilder(a);
                sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
                a=sb.toString();
            }
            sb2.append(a).append(" ");
        }
        System.gc();
    return sb2.substring(0,sb2.length()-1);
    }
    public static void main(String[] args) {
    var c=new lc2129();

        System.out.println(c.capitalizeTitle("capiTalIze He titLe"));
    }
}

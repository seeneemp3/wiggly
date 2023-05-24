package leetcode_codewars;

public class Maximum_Value_of_a_String_in_an_Array {
    public  int maximumValue(String[] strs) {
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (String s : strs) {
            if (s.matches("[0-9]+")) {
                count = Integer.parseInt(s);
            } else count = s.length();
            max=Math.max(max,count);


        }return max;
    }


    public static void main(String[] args) {
        Maximum_Value_of_a_String_in_an_Array x=new Maximum_Value_of_a_String_in_an_Array();

        System.out.println(x.maximumValue(new String[]{"alic389","bob","3","4","00000000000"}));
    }
}

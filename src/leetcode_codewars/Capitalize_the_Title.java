package leetcode_codewars;

public class Capitalize_the_Title {
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
    var c=new Capitalize_the_Title();

        System.out.println(c.capitalizeTitle("capiTalIze He titLe"));
    }
}

package leetcode_codewars.alogorithmics;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sum_of_ints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Pattern.compile("").splitAsStream(sc.nextLine()).mapToInt(Integer::parseInt).sum();
        System.out.println(Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sum());


    }
}

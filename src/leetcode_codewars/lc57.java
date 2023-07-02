package leetcode_codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

/*57. Insert Interval
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
Constraints:
0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105*/
public class lc57 {
   static int [][] intervals = new int [][] {{1,2},{3,5}, {6,7}, {8,10},{12,16}};
    static int [] newInterval = new int [] {4,8};

//    static int [][] intervals = new int [][] {{1,3},{6, 9}};
//    static int [] newInterval = new int [] {2, 12};

//    static int [][] intervals = new int [][] {{1,5}};
//    static int [] newInterval = new int [] {2, 7};

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new LinkedList<>();
        int [] ar = new int [] {-1, -1};
        boolean added = false;


        if (intervals.length == 0){
            list.add(newInterval);
        }


            for (int i = 0; i < intervals.length; i++) {
                if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                  ar[0] = intervals[i][0];
                } else if ((newInterval[0] < intervals[i][0]) && ar[0] == -1) {
                    ar[0] = newInterval[0];
                }
                if (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                    ar[1] = intervals[i][1];
                } else if (newInterval[1] < intervals[i][0] && ar[1] == -1) {
                    ar[1] = newInterval[1];
                }

                if (Arrays.equals(intervals[i], intervals[intervals.length - 1]) && newInterval[1] > intervals[i][1]){
                    ar[1] = newInterval[1];
                }
                if (Arrays.equals(intervals[i], intervals[0]) && newInterval[0] < intervals[i][0]){
                    ar[0] = newInterval[0];
                }





                if (ar[0] == -1){
                    list.add(intervals[i]);
                }
                if(ar[1] != -1 && !added ) {
                    if(ar[0] == -1) ar[0] = newInterval[0];
                    list.add(ar);
                    added = true;
                }
                if(added && ar[1] != intervals[i][1] && !(Arrays.equals(intervals[i], intervals[intervals.length - 1]) && newInterval[1] > intervals[i][1])) {
                    list.add(intervals[i]);
                }

               // System.out.println(Arrays.toString(ar));
            }
       // System.out.println("\n");


        int [][] fin = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            fin[i] = list.get(i);
        }

        list.forEach(s -> System.out.println(Arrays.toString(s)));
        return fin;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

}

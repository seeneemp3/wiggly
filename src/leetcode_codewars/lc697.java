package leetcode_codewars;


import java.util.*;


/*Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation:
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.


Constraints:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.*/
public class lc697 {
  /*
  find N = frequently used

     for each N find min as {
        delete arr[0] until N
        delete arr[arr.l - 1] until N
        set min as result of arr.length()
     }
*/
    /*
    public int findShortestSubArray(int[] nums) {
        int max=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: nums){
            list.add(i);
            map.put(i,map.getOrDefault(i,0)+1);
            if((int)map.get(i)>max)
                max=map.get(i);
        }
        int min = Integer.MAX_VALUE;
        for(Map.Entry m: map.entrySet()){
            if((int)m.getValue()==max){
                int num = (int)m.getKey();
                int n1 = list.indexOf(num);
                int n2 = list.lastIndexOf(num);
                if(n2-n1+1<min)
                    min=n2-n1+1;
            }
        }
        return min;
    }
    */
     private Map.Entry <Integer, Integer> maxUsed = Map.entry(0, 0);
     private List <Map.Entry <Integer, Integer> > list = new ArrayList<>();

     int getLength(int[] arr, Map.Entry <Integer, Integer> a){
        int first = 0;
        int last = 0;
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] == a.getKey()) first = i;
        }
        for (int i = arr.length-1; i >=0; i--) {
            if (arr[i] == a.getKey()) last = i;
        }
        return first-last+1;
    }
     public int findShortestSubArray(int[] nums) {
        Map <Integer, Integer> hm = new HashMap<>();
        for( int s : nums) hm.put(s, hm.getOrDefault(s, 0) + 1);
        hm.entrySet().forEach(s -> {if (s.getValue() >= maxUsed.getValue()) maxUsed = s;});
        hm.entrySet().forEach(s -> {if (s.getValue().equals(maxUsed.getValue())) list.add(s);});

        return list.stream().map( s -> getLength(nums, s)).min(Integer::compareTo).orElse(0);
    }



  public static void main(String[] args) {
      int[] n = new int[] {1,2,2,3,1,4,2};
      System.out.println(new lc697().findShortestSubArray(n));

  }
}
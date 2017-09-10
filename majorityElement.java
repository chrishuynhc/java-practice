import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        
        int maj = 0;
        Hashtable<Integer, Integer> myTable = new Hashtable<Integer, Integer>();
        
        for (int num: nums){
            if (!myTable.containsKey(num)){
                myTable.put(num, 1);
            } else {
                myTable.put(num, myTable.get(num) + 1);
            }
            if (myTable.get(num) > (nums.length/2)){
                maj = num;
                break;
            }
        }
        return maj;
    }
    
    public int majorityElement2(int[] nums) {
        
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }  
}
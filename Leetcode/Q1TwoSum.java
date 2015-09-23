package q001to020;

import java.util.*;

public class Q1TwoSum {
	public int[] twoSum(int[] nums, int target) {
        /**int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
        	for (int j = i + 1; j < nums.length; j++){
        		if ( nums[i] + nums[j] == target){
        			result[0] = i + 1;
        			result[1] = j + 1;
        		}
        	}
        }
        return result;**/
		int[] result = new int[2];
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++){
			if (numMap.containsKey(target- nums[i])){
				result[0] = numMap.get(target- nums[i]);
				result[1] = i + 1;
			}
			numMap.put(nums[i], i + 1);
		}
		return result;
    }
	public static void main(String[] args) {
		Q1TwoSum ts = new Q1TwoSum();
		int[] a = {2, 7, 11, 15}; 
		int[] b = ts.twoSum(a, 9);
		for (int i: b) System.out.println(i);
	}
}

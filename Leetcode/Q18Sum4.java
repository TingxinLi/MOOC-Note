package q001to020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18Sum4 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
        	if ( i > 0 && nums[i] == nums[i-1]) continue;
        	for (int j = i + 1; j < nums.length - 2; j++){
        		if (j > i + 1 && nums[j] == nums[j-1]) continue;
        		JudgeAndPut(nums, nums[i], nums[j], j + 1, nums.length - 1, result, target);
        	}
        }
        return result;
    }
    private void JudgeAndPut(int[] nums, int n1, int n2, int lo, 
    		int hi, List<List<Integer>> result, int target){
    	while ( lo < hi){
    		if (nums[lo] + nums[hi] + n1 + n2 < target) lo++;
    		else if (nums[lo] + nums[hi] + n1 + n2 > target) hi--;
    		else {
    			List<Integer> temp = new ArrayList<Integer>();
    			temp.add(n1);
    			temp.add(n2);
    			temp.add(nums[lo]);
    			temp.add(nums[hi]);
    			lo++;
    			hi--;
    			result.add(temp);
    			while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
    			while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
    		}
    	}
    }
	public static void main(String[] args) {
		Q18Sum4 s4 = new Q18Sum4();
		int[] a = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> b = new ArrayList<List<Integer>>();
		b = s4.fourSum(a, 0);
		for (List<Integer> i: b) System.out.println(i.toString());
	}
}

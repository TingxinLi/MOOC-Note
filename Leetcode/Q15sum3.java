package q001to020;

import java.util.*;

public class Q15sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
        	if ( i > 0 && nums[i] == nums[i-1]) continue;
        	else JudgeAndPut(nums, nums[i], i + 1, nums.length - 1, result);
        }
        return result;
    }
    private void JudgeAndPut(int[] nums, int target, int begin, int end, List<List<Integer>> result){
    	while ( begin < end){
    		if (nums[begin] + nums[end] + target < 0) begin++;
    		else if (nums[begin] + nums[end] + target > 0) end--;
    		else {
    			List<Integer> temp = new ArrayList<Integer>();
    			temp.add(target);
    			temp.add(nums[begin]);
    			temp.add(nums[end]);
    			begin++;
    			end--;
    			result.add(temp);
    			while (begin < end && nums[begin] == nums[begin - 1]) begin++;
    			while (begin < end && nums[end] == nums[end + 1]) end--;
    		}
    	}
    }
	public static void main(String[] args) {
		Q15sum3 s3 = new Q15sum3();
		int[] a = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> b = new ArrayList<List<Integer>>();
		b = s3.threeSum(a);
		for (List<Integer> i: b) System.out.println(i.toString());
	}
}

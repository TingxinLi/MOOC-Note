package q001to020;

import java.util.Arrays;

public class Q16Sum3Closet {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int hi, lo;
        for (int i = 0; i < nums.length - 2; i++){
        	lo = i + 1; 
        	hi = nums.length - 1;
        	while ( lo < hi){
        		int temp = nums[i] + nums[lo] + nums[hi];
        		if ( temp == target) return target;
        		else if (temp < target) lo++;
        		else hi--;
        		if ( Math.abs(target - temp) < Math.abs(target - result)) result = temp;	
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Q16Sum3Closet s3c = new Q16Sum3Closet();
		int[] a = {-1, 2, 1, -4};
		System.out.println(s3c.threeSumClosest(a, 1));
		int[] b = {87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,
				11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79
				,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70
				,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,
				-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,
				96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,
				65,55,-89,49,-19,4};
		System.out.println(s3c.threeSumClosest(b, -275));
	}
}

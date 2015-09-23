package q121to140;

public class Q136SingleNumber {
	public int singleNumber(int[] nums) {
        int a = 0;
        for(int i : nums)  a^=i;
        return a;
    }
	public int singleNumber2(int[] nums) {
        for(int i = 1; i < nums.length; i++)  nums[0]^=nums[i];
        return nums[0];
    }
	public static void main(String[] args) {
		
	}
}

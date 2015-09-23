package q121to140;

public class Q137SingleNumber2 {

	public int singleNumber(int[] nums) {
        int result = 0;
        int len = nums.length;
        
        int tempSum;
        for (int i = 0; i < 32; i++) {
        	tempSum = 0;
        	for (int j = 0; j < len; j++) {
        		//System.out.println(nums[j]);
        		tempSum += (nums[j] >> i) & 1;
        	}
        	//System.out.println(tempSum);
        	result |= (tempSum % 3 << i);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		Q137SingleNumber2 sn2 = new Q137SingleNumber2();
		int[] a = {1, 2, 3, 4, 3, 2, 1, 2, 1, 3};
		System.out.println(sn2.singleNumber(a));	
	}
}

package q181to200;

public class Q189RotateArray {
    public void rotate(int[] nums, int k) {
    	if (k >= nums.length) k = k % nums.length;
        int temp[] = new int[k];
    	for (int i = 1; i < k + 1; i++){
    		int tempCir = nums.length - i;
    		temp[i - 1] = nums[tempCir];
    		int j;
    		for (j = 1; j * k + i <= nums.length ; j++){
   			    nums[tempCir] = nums[tempCir - k];
   			    tempCir -= k;
    			//for (int num : nums)  System.out.print(num);
    			//System.out.print("   ");
    		}
    		//System.out.println();
    	}
    	for (int i = 1; i < k + 1; i++){
    		nums[k - i] = temp[i - 1];
    		//for (int num : nums)  System.out.print(num);
    		//System.out.print("   ");
    	}
    }
	public static void main(String[] args) {
		Q189RotateArray ra = new Q189RotateArray();
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		ra.rotate(nums, 3);
		for (int num : nums)  System.out.println(num);
	}
}

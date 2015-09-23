package q041to060;

public class Q41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
    	
        int temp = 0;
        for (int i = 0; i < len; i++) {        		
        	while (nums[i] > 0 && nums[i] < len + 1 && nums[nums[i] - 1] != nums[i]) {
        		temp = nums[nums[i] - 1];
        		nums[nums[i] - 1] = nums[i];
        		nums[i] = temp;
        	}
        }
        
        for (int i = 0; i < len; i++) {
        	if (nums[i] != i + 1) {
        		return i + 1;
        	}
        }
    	return len + 1;
    }
    
    public static void main(String[] args) {
    	Q41FirstMissingPositive fmp = new Q41FirstMissingPositive();
    	int[] a = {2, 1, 0};
    	int[] b = {3,4,-1,1};
    	System.out.println(fmp.firstMissingPositive(a));
    	System.out.println(fmp.firstMissingPositive(b));
	}
}

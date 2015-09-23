package q041to060;

public class Q55JumpGame {
    public boolean canJump(int[] nums) {
    	int len = nums.length;
    	if (len == 0) {
    		return false;
    	}
    	
        int step = nums[0];
        for (int i = 1; i < len; i++) {
        	if (--step < 0) {
        		return false;
        	}
        	
        	if (step < nums[i]) {
        		step = nums[i];
        	}
        }
        return true;
    }
    
    public static void main(String[] args) {
		int[] a = {2, 3, 1, 1, 4};
		int[] b = {3, 2, 1, 0, 4};
		Q55JumpGame jg = new Q55JumpGame();
		
		System.out.println(jg.canJump(a));
		System.out.println(jg.canJump(b));
	}
}

package q181to200;

public class Q198HouseRobber {
    public int rob(int[] nums) {
    	int l = nums.length;
    	if ( l == 0 ) return  0;
    	if ( l == 1 ) return nums[0];
    	if ( l == 2 ) return nums[0] > nums[1] ? nums[0]: nums[1];
    	if ( l == 3 ) return nums[0] + nums[2] > nums[1]?
    			             nums[0] + nums[2] : nums[1];
        int[] recur = new int[l];
        recur[0] = nums[0]; 
        recur[1] = nums[0] > nums[1] ? nums[0]: nums[1];
        recur[2] = nums[0] + nums[2] > nums[1]? nums[0] + nums[2] : nums[1];
        for (int i = 3; i < nums.length; i++){
        	recur[i] = max3(recur[i-1], recur[i-3] + nums[i], recur[i-2] + nums[i]);
        }
        //for (int re : recur)  System.out.println(re);
        return recur[nums.length-1];
    }
    static int max3(int x, int y, int z){
    	int temp = x > y ? x : y;
    	return temp > z ? temp : z;
    }
    
    public static void main(String[] args) {
		Q198HouseRobber hb = new Q198HouseRobber();
		int a[] = {1, 2, 3, 4, 5, 6};
		int b[] = {1, 9, 1, 2, 9, 3};
		System.out.println(hb.rob(a));
		System.out.println(hb.rob(b));
	}
}

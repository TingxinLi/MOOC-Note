package q061to080;

public class Q80RemoveDup2 {
    public int removeDuplicates(int[] nums) {
    	if (nums.length < 1) return 0;
        int base = 0, len = 1;
        for (int i = 1; i < nums.length; i++){
        	if (nums[i] != nums[base]  ){
        		base = i;
        		nums[len++] = nums[i];
        	}
        	else if ( i - base < 2) nums[len++] = nums[i];
        }
        return len;
    }
    public static void main(String[] args) {
    	Q80RemoveDup2 rd2 = new Q80RemoveDup2();
    	int[] a = {1,1,1,2,2,3};
    	System.out.println(rd2.removeDuplicates(a));
	}
}

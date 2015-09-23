package q021to040;

public class Q35SearchInsertPo {
	public int searchInsert(int[] nums, int target) {
        if (nums.length == 0){
        	return -1;
        }
        
		int mid = (nums.length - 1) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		return subSearchInsert(nums, target, 0, nums.length - 1);
    }
	
	private int subSearchInsert(int[] nums, int target, int lo, int hi){
		int mid = lo + (hi - lo) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		
		if (hi - lo <= 1) {
			if (target < nums[lo]) {
				return lo;
			}
			return nums[hi] >= target ? hi : hi + 1;
		}
		
		if (target < nums[mid]){
			return subSearchInsert(nums, target, lo, mid - 1);
		}
		else {
			return subSearchInsert(nums, target, mid + 1, hi);
		}
	}
	
	public static void main(String[] args) {
		Q35SearchInsertPo sip = new Q35SearchInsertPo();
		int[] a = {1, 3, 5, 7, 9};
		int[] b = {1, 3};
		System.out.println(sip.searchInsert(a, 2));
		System.out.println(sip.searchInsert(a, 7));
		System.out.println(sip.searchInsert(a, 0));
		System.out.println(sip.searchInsert(b, 0));
	}
}

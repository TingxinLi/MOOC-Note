package q021to040;

public class Q26RemoveDup {
	public int removeDuplicates(int[] nums) {
        if ( nums.length <= 1 ) return nums.length;
		int thisVal = nums[0], count = 1;
		for (int i = 1; i < nums.length; i++){
			if (nums[i] != thisVal){
				thisVal = nums[i];
				nums[count] = thisVal;
				count++;
			}
		}
		return count;
    }
	public static void main(String[] args) {
		Q26RemoveDup rd = new Q26RemoveDup();
		int[] a = {1, 2, 3, 3, 5};
		System.out.println(rd.removeDuplicates(a));
	}
}

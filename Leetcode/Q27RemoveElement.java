package q021to040;


public class Q27RemoveElement {
	public int removeElement(int[] nums, int val) {
        int count = 0;
        for ( int i = 0; i < nums.length; i++){
        	if ( nums[i] != val)
        		nums[count++] =  nums[i];  	
        }
        for ( int i = 0; i < count; i++) System.out.println(nums[i]);
        return count;
    }
	
	public static void main(String[] args) {
		Q27RemoveElement re = new Q27RemoveElement();
		int[] a = {4, 3, 7, 12, 56, 8, 13, 13};
		System.out.println(re.removeElement(a, 13));
	}
}

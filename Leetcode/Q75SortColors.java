package q061to080;

public class Q75SortColors {
    public void sortColors(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        for (int i = 0; i < nums.length;){
        	if (nums[i] == 0 && i >= lo) exch(nums, i++, lo++);
        	else if (nums[i] == 2 && i <= hi) exch(nums, i, hi--);
        	else i++;
        	for (int a0 : nums) System.out.print(a0 + " ");
        	System.out.println("lo is " + lo + " hi is " + hi);
        }
    }
    private void exch(int[] num, int a, int b){
    	int temp = num[a];
    	num[a] = num[b];
    	num[b] = temp;
    }
    public static void main(String[] args) {
    	Q75SortColors sc = new Q75SortColors();
    	int[] a = {2, 1, 0, 0, 2, 1, 2};
    	sc.sortColors(a);
    	for (int a0 : a) System.out.print(a0 + " ");
    	System.out.println();
    	int[] b = {1, 2, 0};
    	sc.sortColors(b);
    	for (int b0 : b) System.out.print(b0 + " ");
    	int[] c = {0, 1, 0};
    	sc.sortColors(c);
    	for (int c0 : c) System.out.print(c0 + " ");
    	
	}
}

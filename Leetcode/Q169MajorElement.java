package q161to180;

public class Q169MajorElement {
    public int majorityElement(int[] nums) {
    	int count = 0, maj = 0;
    	for ( int i = 0; i < nums.length; i++){
    		if ( count == 0) {
    			maj = nums[i];
    			count++;
    		}
    		else if ( nums[i] == maj) count++;
    		else count--;
    	}
        return maj;
    }

    public static void main(String[] args) {
    	Q169MajorElement me = new Q169MajorElement();
    	int[] a = {5, 9, 7, 8, 6, 5, 5, 5, 5, 5, 4};
    	System.out.println(me.majorityElement(a));
	}
}

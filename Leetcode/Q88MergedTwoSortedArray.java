package q081to100;

public class Q88MergedTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ( n == 0 ) return;
    	int[] temp = new int[m];
        for (int i = 0; i < m; i++) temp[i] = nums1[i];
        int c0 = 0, c1 = 0, c2 = 0;
        while ( c0 < nums1.length ){
        	if ( c1 == m ) nums1[c0] = nums2[c2++];
        	else if (c2 == n )nums1[c0] = temp[c1++];
        	else if ( temp[c1] < nums2[c2] ) nums1[c0] = temp[c1++];
        	else nums1[c0] = nums2[c2++];
        	c0++;
        }
    }
    public static void main(String[] args) {
    	Q88MergedTwoSortedArray m2 = new Q88MergedTwoSortedArray();
    	int a[] = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
		int b[] = {2, 4, 6, 8, 10};
		//m2.merge(a, 5, b, 5);
		//for (int i : a ) System.out.println(i);
		int c[] = {2, 0};
		int d[] = {1};
		m2.merge(c, 1, d, 1);
		for (int j : c ) System.out.println(j);
	}
}

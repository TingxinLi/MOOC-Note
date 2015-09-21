package week3;

public class QSort2Way {
	public void qsort(int[] arr, int begin, int end){
		if ( begin >= end - 1) return;
		int par = partition2way(arr, begin, end);
		qsort(arr, begin, par);
		qsort(arr, par + 1, end);
	}
	private int partition2way(int[] arr, int begin, int end){
		int par = arr[begin];
		int i = begin + 1, j = end - 1;
		while( true ){
			while ( arr[i] <= par && i < end - 1) i++;
			while ( arr[j] >= par && j > begin) j--;
			if ( i >= j ) break;
			exch(arr, i++, j--);
		}
		exch(arr, begin, j);
		//for (int k = begin; k < end; k++) System.out.print(arr[k] + " ");
		//System.out.println("Begin and end and par: " + begin + " " + end + " " + j);
		return j;
	}
	private void exch(int[] arr, int lo, int hi){
		int temp = arr[lo];
		arr[lo] = arr[hi];
		arr[hi] = temp;
	}
	public static void main(String[] args) {
		QSort2Way q2 = new QSort2Way();
		int[] a = {85, 97, 50, 86, 68, 35, 42, 61, 49, 99, 16, 38};
		q2.qsort(a, 0, a.length);
		System.out.println("---------------");
		for (int k = 0; k < a.length; k++) System.out.print(a[k] + " ");
		System.out.println("\n---------------");
		int[] b = {3, 4, 2, 1};
		q2.qsort(b, 0, b.length);
		for (int k = 0; k < b.length; k++) System.out.print(b[k] + " ");
		System.out.println("\n---------------");
	}
}

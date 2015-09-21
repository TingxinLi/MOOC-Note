package week3;

public class QSort3Way {
	public void qsort(int[] arr, int begin, int end){
		partition2way(arr, begin, end);
	}
	private void partition2way(int[] arr, int begin, int end){
		if ( begin >= end ) return;
		int lt = begin, ht = end - 1, i = begin;
		int v = arr[begin];
		while ( i <= ht){
			if ( arr[i] < v ) exch(arr, lt++, i++);
			else if ( arr[i] > v) exch(arr, i, ht--);
			else i++;
		}
		for (int k = begin; k < end; k++) System.out.print(arr[k] + " ");
		System.out.println();
	}
	private void exch(int[] a, int lo, int hi){
		int temp = a[lo];
		a[lo] = a[hi];
		a[hi] = temp;
	}
	public static void main(String[] args) {
		QSort3Way q2 = new QSort3Way();
		int[] a = {59, 59, 39, 49, 19, 84, 52, 59, 38, 85};
		q2.qsort(a, 0, a.length);
		int[] b = {3, 3, 4, 1};
		q2.qsort(b, 0, b.length);
	}
}

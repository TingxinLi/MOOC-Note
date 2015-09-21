package week3;

public class QSort3WayChar {
	public void qsort(char[] arr, int begin, int end){
		partition2way(arr, begin, end);
	}
	private void partition2way(char[] arr, int begin, int end){
		if ( begin >= end ) return;
		int lt = begin, ht = end - 1, i = begin;
		char v = arr[begin];
		while ( i <= ht){
			if ( arr[i] < v ) exch(arr, lt++, i++);
			else if ( arr[i] > v) exch(arr, i, ht--);
			else i++;
		}
		for (int k = begin; k < end; k++) System.out.print(arr[k] + " ");
		System.out.println();
	}
	private void exch(char[] a, int lo, int hi){
		char temp = a[lo];
		a[lo] = a[hi];
		a[hi] = temp;
	}
	public static void main(String[] args) {
		QSort3WayChar q2 = new QSort3WayChar();
		char[] c = {'B', 'B', 'B', 'B', 'B', 'A', 'A', 'B', 'A', 'A', 'B', 'B'};
		q2.qsort(c, 0, c.length);
	}
}

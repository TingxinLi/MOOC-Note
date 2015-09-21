package week3;

public class MergeSortTopDown {
	private int count = 0;
	public void msortTD(int[] arr, int begin, int end){
		count++;
		if ( arr.length == 1 ) return ;
		int[] lux = new int[end - begin];
		
		
		//for (int c : a) System.out.print(c + " ");
	}
	public static void main(String[] args) {
		MergeSortTopDown ms= new MergeSortTopDown();
		int[] a = {30, 45, 38, 27, 74, 19, 82, 90, 84, 54, 11, 94};
		ms.msortTD(a, 0, a.length);
		for (int c : a) System.out.print(c + " ");
	}
}

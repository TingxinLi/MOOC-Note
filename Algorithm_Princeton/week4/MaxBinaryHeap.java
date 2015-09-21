package week4;

/**
 * @author litx3
 * Array start at bHeap[1]
 * N should always equal to the the actual length of the 
 */
public class MaxBinaryHeap {
	private static int N = 0;
	private static int[] bHeap;
	
	public MaxBinaryHeap(){
		bHeap = new int[4];
	}
	private void Insert(int num){
		if (bHeap.length == N + 1) bHeap = Resize(bHeap, 2 * N);
		bHeap[++N] = num;
		Swim(N);
		for (int i = 1; i <= N; i++) System.out.print(bHeap[i] + "  ");
		System.out.println();
	}
	
	private void DelMax(){
		Swap(1, N--);
		Sink(1);
		if (N < bHeap.length / 4) Resize(bHeap, bHeap.length / 2);
		for (int i = 1; i <= N; i++) System.out.print(bHeap[i] + "  ");
		System.out.println();
	}
	
	private int[] Resize(int[] arr, int n){
		int[] result = new int[n];
		for (int i = 0; i < arr.length; i++) result[i] = arr[i];
		return result;
	}
	
	private void Init(int[] imp){
		bHeap = new int[imp.length + 1];
		for (int i = 0; i < imp.length; i++) bHeap[i + 1] = imp[i];
		N = bHeap.length - 1;
	}
	
	private void Sink(int num){
		while (num * 2 <= N){
			int i = num * 2;
			if (i + 1 <= N && bHeap[i + 1] > bHeap[i]) i++;
			if (bHeap[num] > bHeap[i]) break;
			Swap(num, i);
			num = i;
		}
	}
	
	private void Swim(int num){
		while (num > 1 && bHeap[num] > bHeap[num / 2]){
			Swap(num, num / 2);
			num /= 2;
		}
	}
	
	private void Swap(int i, int j){
		int temp = bHeap[i];
		bHeap[i] = bHeap[j];
		bHeap[j] = temp;
	}
	
	public static void main(String[] args) {
		MaxBinaryHeap mbh = new MaxBinaryHeap();
		int[] a = {88, 85, 73, 78, 81, 40, 67, 29, 15, 47};
		mbh.Init(a);
		mbh.Insert(72);
		mbh.Insert(49);
		mbh.Insert(57);
		System.out.println("------------------------");
		for (int i = 1; i <= N; i++) System.out.print(bHeap[i] + " ");
		System.out.println("\n------------------------");
		int[] b = {73, 69, 72, 62, 40, 11, 53, 17, 55, 38};
		mbh.Init(b);
		mbh.DelMax();
		mbh.DelMax();
		mbh.DelMax();
		System.out.println("------------------------");
		for (int i = 1; i <= N; i++) System.out.print(bHeap[i] + " ");
		System.out.println("\n------------------------");
	}
}

package week2;

public class ShellSort3x1 {
	public boolean less(int a, int b){
		return a - b < 0;
	}
	public void swap(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	public void shell3x1(int[] arr){
		int n = 1;
		while (3 * n + 1 < arr.length) n = n * 3 + 1;
		System.out.println(n);
		while (n > 0){
			for (int i = 0; i< n; i++){
				int j = 1;
				while (j * n + i < arr.length ){
					int k = j;
					while ( k >= 1){
						if (less(arr[ k * n + i], arr[(k-1)* n +i])) swap(arr,  k * n + i, (k-1)* n +i);	
						k--;
					}
					j++;
				}
				for (int l: arr) System.out.print(String.valueOf(l) + " ");
				System.out.println("");
			}
			n /= 3;	
		}
	}
    public static void main(String[] args) {
    	ShellSort3x1 ss3x1 = new ShellSort3x1();
    	int[] a = {46, 28, 75, 32, 13, 45, 31, 25, 15, 27 };
    	ss3x1.shell3x1(a);
    }
}

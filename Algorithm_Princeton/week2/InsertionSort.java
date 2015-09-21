package week2;

public class InsertionSort {
	public boolean less(int a, int b){
		return a - b < 0;
	}
	public void swap(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
    public void insert(int[] array){
    	int cnt = 0;
    	for (int i = 1; i < array.length; i++){
    		for (int j = i; j > 0; j--){
    			if (less(array[j], array[j-1])) {
    				swap(array, j-1, j);
    	    		for (int a : array) System.out.print( String.valueOf(a) + ' ' );
    	    		System.out.println("The " + String.valueOf(++cnt) + " exchanges.");
    			}
    		}
    	}
    }
    public static void main(String[] args) {
    	InsertionSort ss = new InsertionSort();
    	int[]  a = {0, 5, 1, 6, 2, 7, 3, 8, 4, 9 }; 
    	ss.insert(a);
    }
}

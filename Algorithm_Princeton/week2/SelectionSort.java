package week2;

/**
 * @author Travis
 *  Give the array that results after the first x exchanges 
 *  when selection sorting the following array.
 */
public class SelectionSort {
	public boolean less(int a, int b){
		return a - b < 0;
	}
	public void swap(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
    public void select(int[] array){
    	for (int i = 0; i < array.length; i++){
			int min = i;
    		for (int j = i; j < array.length; j++){
    			if (less(array[j], array[min])) min = j;
    		}
    		swap(array, i, min);
    		for (int a : array) System.out.print( String.valueOf(a) + ' ' );
    		System.out.println("The " + String.valueOf(i+1) + " sorts.");
    	}
    }
    public static void main(String[] args) {
    	SelectionSort ss = new SelectionSort();
    	int[]  a = {87, 17, 48, 96, 47, 15, 68, 54, 27, 12};
    	ss.select(a);
	}
}

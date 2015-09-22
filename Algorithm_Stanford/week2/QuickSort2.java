package week2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class QuickSort2 {
	private long count;
	public long CountQsort(int[] arr){
		count = 0;
		SubQsort(arr, 0, arr.length - 1);
		count += arr.length - 1;
		System.out.println("After quick sort: ");
		for (int i: arr) System.out.print(i + " ");
		System.out.println();
		return count;
	}
	
	private void SubQsort(int[] arr, int lo, int hi){
		if ( hi - lo == 0 ) return;
		/**
		System.out.print("Sub Array is: ");
		for (int k = lo; k <= hi; k++) System.out.print(arr[k] + "  ");
		System.out.println();
		**/
		Swap(arr, lo, hi);
		int pivot = arr[lo], i = lo + 1;
		for (int j = lo + 1; j <= hi; j++)
			if (arr[j] < pivot) Swap(arr, j, i++);
		Swap(arr, lo, i - 1);
		if (i - 1 > lo)	{
			SubQsort(arr, lo, i - 2);
			count += i - 2 - lo;
		}
		if (i < hi) {
			SubQsort(arr, i, hi);
			count += hi - i;
		}
	}
	
	private void Swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		QuickSort2 qs2 = new QuickSort2();
		/**
		int[] t1 = {7, 5, 1, 4, 8, 3, 10, 2, 6, 9};
		System.out.println("Compare num in sorting: " + qs2.CountQsort(t1));
		int[] t2 = {8, 10, 1, 9, 7, 2, 6, 3, 5, 4};
		System.out.println("Compare num in sorting: " + qs2.CountQsort(t2));
		**/
		
		int[] testArray = new int[10000];
		int num = 0;
		try {
            String encoding="GBK";
            File file=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week2/QuickSort.txt");
            if(file.isFile() && file.exists()){ //Ensure that file exists
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//Consider the coding of the text
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	if (num >= 10000) break;
                    testArray[num++] = Integer.parseInt(lineTxt);
                }
                read.close();
            }else{
            	System.out.println("File not found.");
            }
		} catch (Exception e) {
			System.out.println("Error exist while reading.");
			e.printStackTrace();
		}
		System.out.println("num is " + num);;
		System.out.println("Compare num is " + qs2.CountQsort(testArray));
		
	}
}

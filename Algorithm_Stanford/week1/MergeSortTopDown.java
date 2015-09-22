package week1;



/**
 * @author Travis
 * This program is to count the inversion of a group of number by Merge Sort.
 */
public class MergeSortTopDown {
	private long count;
	public long msortTD(int[] arr){
		count = 0;
		subMergeSort(arr, 0, (arr.length - 1)/2, arr.length - 1);
		return count;
	}
	
	private void subMergeSort(int[] arr, int begin, int mid, int end){
		if ( end - begin == 0 ) return;
		if ( end - begin == 1)
			if ( arr[end] < arr[begin]){
				int temp = arr[end];
				arr[end] = arr[begin];
				arr[begin] = temp;
				count++;
				return;
			}
		//System.out.print("Sub Array is: ");
		//for (int k = begin; k <= end; k++) System.out.print(arr[k] + "  ");
		//System.out.println();
		subMergeSort(arr, begin, (begin + mid) / 2, mid);
		subMergeSort(arr, mid + 1, (mid + 1 + end) / 2, end);
		assert isSorted(arr, begin, mid);    
		assert isSorted(arr, mid + 1, end);
		
		int aux[] = new int[end - begin + 1];
		int i = begin, j = mid + 1;
		for (int k = 0; k < aux.length; k++){
			if (i > mid)              aux[k] = arr[j++];
			else if (j > end)         aux[k] = arr[i++];
			else if (arr[i] <= arr[j]) aux[k] = arr[i++];
			else {
				aux[k] = arr[j++];
				count += mid + 1 - i;
			}
		}
		for (int k = 0; k < aux.length; k++){
			arr[k + begin] = aux[k];
		}
		assert isSorted(arr, begin, end);
	}
	
	private boolean isSorted(int[] arr, int lo, int hi){
		for (int i = lo; i < hi; i++){
			if (arr[i] > arr[i+1])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		MergeSortTopDown ms= new MergeSortTopDown();
		
		int[] a = {30, 45, 38, 27, 74, 19, 82, 90, 84, 54, 11, 94};
		System.out.println(ms.msortTD(a));
		for (int i : a) System.out.print(i + "  ");
		System.out.println("\n------------------------");
		int[] b = {1,3,5,2,4,6};
		System.out.println(ms.msortTD(b));
		for (int i : b) System.out.print(i + "  ");
		System.out.println("\n------------------------");
		int[] c = {9, 12, 3, 1, 6, 8, 2, 5, 14, 13, 11, 7, 10, 4, 0 };
		System.out.println(ms.msortTD(c));
		for (int i : c) System.out.print(i + "  ");
		System.out.println("\n------------------------");
		int[] d = {49, 105, 93, 107, 90, 125, 16, 144, 141, 48, 58, 150, 62, 47, 108, 126, 92, 35, 20, 41, 46, 70, 132, 96, 39, 13, 67, 117, 124, 136, 45, 122, 29, 6, 31, 21, 18, 28, 146, 69, 3, 44, 138, 101, 86, 5, 94, 52, 84, 76, 51, 7, 27, 99, 100, 113, 109, 110, 116, 40, 22, 50, 59, 130, 15, 66, 139, 97, 9, 34, 112, 10, 115, 37, 53, 38, 64, 121, 120, 17, 127, 56, 80, 42, 23, 55, 145, 65, 131, 2, 104, 78, 4, 123, 114, 89, 72, 71, 82, 111, 54, 85, 143, 134, 128, 63, 118, 149, 24, 43, 91, 129, 26, 87, 81, 77, 57, 25, 79, 147, 60, 102, 74, 88, 148, 61, 142, 32, 137, 11, 36, 140, 98, 106, 95, 1, 30, 135, 119, 103, 14, 33, 73, 75, 68, 12, 19, 133, 83, 8};
		System.out.println(ms.msortTD(d));
		for (int i : d) System.out.print(i + "  ");
		
		/**
		int[] testArray = new int[100000];
		int num = 0;
		try {
            String encoding="GBK";
            File file=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week1/IntegerArray.txt");
            if(file.isFile() && file.exists()){ //Ensure that file exists
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//Consider the coding of the text
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	if (num >= 100000) break;
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
		System.out.println(num);
		System.out.println(ms.msortTD(testArray));
		**/
	}
}

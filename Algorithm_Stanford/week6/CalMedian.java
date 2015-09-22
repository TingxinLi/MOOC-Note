package week6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class CalMedian {

	private PriorityQueue<Integer> largeHalf;
	private PriorityQueue<Integer> smallHalf;
	private String encoding="GBK";
	private int[] input;
	private int[] median;
	private int medianSum;
	
	public CalMedian(File file, int size){
		input = new int[size];
		median = new int[size];
		medianSum = 0;
		readArray(file, size);
		
		largeHalf = new PriorityQueue<Integer>();
		smallHalf = new PriorityQueue<Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) return -1;
				else if (o2 > o1) return 1;
				return 0;
			}
			
		});
		
		median[0] = input[0];
		smallHalf.add(input[0]);
		medianSum += median[0];
		for(int i = 1; i < size; i++){
			if (largeHalf.size() == smallHalf.size()){
				if (input[i] > largeHalf.peek()){
					smallHalf.add(largeHalf.poll());
					largeHalf.add(input[i]);
				}
				else{
					smallHalf.add(input[i]);
				}
			}
			else {
				if (input[i] < smallHalf.peek()){
					largeHalf.add(smallHalf.poll());
					smallHalf.add(input[i]);
				}
				else{
					largeHalf.add(input[i]);
				}
			}
            
			//Test for whether there is wrong moving
			if (largeHalf.size() > smallHalf.size())  System.out.println("!!!!!!!!!!!!!!ERROR!!!!!!!!!!!!!!!");
			median[i] = smallHalf.peek();
			medianSum += median[i];
		}
	}
	
	public void readArray(File file, int size){
		//System.out.println("Size : " + size);
		int count = 0;
		try {  
            if(file.isFile() && file.exists()){ //Ensure that file exists
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	//System.out.println(lineTxt);
                	input[count++] = Integer.parseInt(lineTxt);
                }
                read.close();
            }else{
            	System.out.println("File not found.");
            }
		} catch (Exception e) {
			System.out.println("Error exist while reading.");
			e.printStackTrace();
		}
		
		if (count != size) System.out.println("!!!!!!!!!!!ERROR!!!!!!!!!!!");
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Medians of the input are: \n");
		for (int i = 0; i < median.length; i++){
			sb.append(median[i] + " ");
		}
		sb.append("\nSum of the medians is: " + medianSum);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		File file1=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week6/text2.txt");
		CalMedian cm1 = new CalMedian(file1, 20);
		System.out.println(cm1);
		
		
		File file2=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week6/Median.txt");
		CalMedian cm2 = new CalMedian(file2, 10000);
		System.out.println(cm2);
		
	}
}

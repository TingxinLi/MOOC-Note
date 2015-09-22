package week6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Sum2 {

	private long[] input;
	private int sum;
	private String encoding="GBK";
	
	public Sum2(File file, int size){
		input = new long[size];
		readArray(file, size);
		sum = 0;
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Long> set2 = new HashSet<Long>();
		
		for(int i = 0; i < size; i++){
			for (int j = -10000; j <= 10000; j++){
				if (set2.contains(j - input[i])){
					set1.add(j);
				}
			}
			set2.add(input[i]);
			if (i % 10000 == 0) System.out.println(i);
		}
        sum = set1.size();
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
                	input[count++] = Long.parseLong(lineTxt);
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
		return String.valueOf(sum);
	}
	/**
	private String printSet(HashSet<Long> set){
		StringBuffer sb = new StringBuffer();
		Iterator<Long> it = set.iterator();
		sb.append("HashSet: \n");
		while (it.hasNext()){
			long temp = it.next();
			sb.append(String.valueOf(temp) + " ");
		}
		return sb.toString();
	}**/
	
	public static void main(String[] args) {
		File file1=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week6/text1.txt");
		Sum2 sumTrial = new Sum2(file1, 20);
		System.out.println(sumTrial);
		
		
		File file2=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week6/algo1-programming_prob-2sum.txt");
		Sum2 sumTrial2 = new Sum2(file2, 1000000);
		System.out.println(sumTrial2);
		// Answer of this question is 427.
		
	}
}

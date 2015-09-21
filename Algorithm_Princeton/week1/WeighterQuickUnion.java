package week1;

import java.util.Scanner;

public class WeighterQuickUnion {
	/**
	 weighted quick union algorithm
	*/
	private int[] id;
	private int[] size;
    
	
	public void init(int N){
		id = new int[N];
		size = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	private int root(int i){
		while (id[i] != i) i = id[i];
		return i;
	}

	public boolean connected(int p, int q){
		return root(p) == root(q);
	}
	
	void check(int i, int j){
		int p = root(i);
		int q = root(j);
		if ( id[p] != id[q] ){
		    if ( size[p] < size[q] ){
		    	id[p] = q;
		    	size[q] += size[p];
		    }
		    else{
		    	id[q] = p;
		    	size[p] += size[q];
		    }
		}
	}
	
	void printResult(){
		for (int i = 0; i < 10; i++){
			System.out.print(id[i]);
			System.out.print("  ");
		}
		for (int i = 0; i < 10; i++){
			System.out.print(size[i]);
			System.out.print("  ");
		}
		System.out.println("");
	}
	public static void main(String [] args)
	{
		WeighterQuickUnion wqUnion = new WeighterQuickUnion();
		wqUnion.init(10);
		int count = 0, inputTimes = 9;
		Scanner reader = new Scanner(System.in);
		while (count < inputTimes){
			int p = reader.nextInt();
			int q = reader.nextInt();
			wqUnion.check(p, q);
			count ++;
			wqUnion.printResult();
		}
		reader.close();
	}
	//enter the following as input :2 8 7 4 4 3 7 0 5 3 1 5 6 9 6 8 5 8  
}

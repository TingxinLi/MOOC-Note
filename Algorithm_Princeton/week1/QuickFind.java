package week1;


import java.util.*;
 
public class QuickFind{
	/**
	quick find algorithm
	*/
	public static void main(String [] args)
	{
		int id[] = new int[10];
		int p, q, count = 0;
		for (int i = 0; i < 10; i++){
			id[i] = i;
		}
		Scanner reader =new Scanner(System.in);
		while (count < 6){
			p = reader.nextInt();
			q = reader.nextInt();
			if ( id[p] != id[q] ){
				int temp = id[p];
				for (int i = 0; i < 10; i++){
					if ( id[i] == temp)
						id[i] = id[q];
				}
			}
			count ++;
			for (int i = 0; i < 10; i++){
				System.out.print(id[i]);
				System.out.print("  ");
			}
			System.out.println("");
		}
		reader.close();
	}
	//enter the following as input :0 4 7 6 4 9 2 6 5 0 7 3  
}


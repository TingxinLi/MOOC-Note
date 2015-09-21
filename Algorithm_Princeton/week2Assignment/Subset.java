package week2Assignment;

import edu.princeton.cs.algs4.*;

public class Subset {
	public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();  
        int k = Integer.parseInt(args[0]);  
        while (!StdIn.isEmpty())  
            rq.enqueue(StdIn.readString());  
        for (int i = 0; i < k; i++)  
            StdOut.println(rq.dequeue());  
	}
}

package week3Assignment;

import edu.princeton.cs.algs4.*;

public class Brute {
	private static void exch(Point[] p, int i, int j){
		Point temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	} 
	public static void main(String[] args) {
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		
		In in = new In(args[0]);
		int num = in.readInt();
		Point[] p = new Point[num];
		
		for (int i = 0; i < num; i++){
			int x = in.readInt();
			int y = in.readInt();
			p[i] = new Point(x, y);
			p[i].draw();
		}
		
		for (int i = 1; i< num; i++)
			for ( int j = i; j >= 1; j--)
				if ( p[j].compareTo(p[j - 1]) <= 0) exch(p, j, j-1);
			
		for (int i = 0; i < num; i++)
			for (int j = i + 1; j < num; j++)
				for (int k = j + 1; k < num; k++)
					for (int l = k + 1; l < num; l++)
						if (p[i].slopeTo(p[j]) == p[j].slopeTo(p[k]) && p[j].slopeTo(p[k]) == p[k].slopeTo(p[l])){
							StdOut.println(p[i] + " -> " + p[j] + " -> " + p[k]+ " -> " + p[l]);
							p[i].drawTo(p[l]);
						}			
	}
}

package week1Assignment;

import edu.princeton.cs.algs4.*;

public class PercolationStats {
	private double x[];
	private int repT;
    public PercolationStats(int N, int T) {    // perform T independent experiments on an N-by-N grid
    	if (N <= 0 || T <= 0) 
            throw new IllegalArgumentException("Illeagal Argument");
    	x = new double[T];
    	repT = T;
    	for (int k = 0; k < T; k ++){
    	    Percolation p1 = new Percolation(N);
    	    while (true){
    	        int i,j;
		        do {
		    	    i = StdRandom.uniform(1,N+1);
		    	    j = StdRandom.uniform(1,N+1);
		        } while (p1.isOpen(i, j));
		        p1.open(i, j);
		        x[k] ++;
		        if (p1.percolates()) {
		        	x[k] = x[k]/(double)(N * N);
		        	break;
		        }
    	    }
    	}
	}
    
	public double mean(){                      // sample mean of percolation threshold
	    double u = 0.0; 
	    for (int i = 0; i < repT; i++){
	    	u += x[i];
	    }
	    return u/repT;
	}
	
	public double stddev() {                   // sample standard deviation of percolation threshold
	    double ro = 0.0;
	    double uAve = mean();
	    for (int i = 0; i < repT; i++){
	    	ro += ( x[i] - uAve ) * ( x[i] - uAve ) ;
	    }
	    return Math.sqrt(ro/(repT - 1));
	}
	
	public double confidenceLo() {             // low  endpoint of 95% confidence interval
	    double uAve = mean();
	    double roAve = stddev();
	    return uAve - 1.96 * roAve / Math.sqrt(repT);
	}
	public double confidenceHi() {             // high endpoint of 95% confidence interval
		double uAve = mean();
	    double roAve = stddev();
	    return uAve + 1.96 * roAve / Math.sqrt(repT);
	}
    public static void main(String[] args){    // test client (described below)
		PercolationStats ps = new PercolationStats(200, 100);
		StdOut.printf("mean = %f\n", ps.mean());
	    StdOut.printf("stddev = %f\n", ps.stddev());
	    StdOut.printf("95%% confidence interval = %f, %f\n", 
	                   ps.confidenceLo(), ps.confidenceHi());
	}
}

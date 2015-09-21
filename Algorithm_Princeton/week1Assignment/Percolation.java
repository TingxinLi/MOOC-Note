package week1Assignment;

public class Percolation {
	private WeightedQuickUnionUF uf;
	private WeightedQuickUnionUF ufBackWash;
	private boolean openSta[];
	private int N;
	
    public Percolation(int Ni){               // create N-by-N grid, with all sites blocked
    	if (Ni < 1) throw new IllegalArgumentException("Illeagal Value for N");
    	N = Ni;
    	openSta = new boolean[N * N + 2];
        uf = new WeightedQuickUnionUF(N * N + 2);
        ufBackWash = new WeightedQuickUnionUF(N * N + 1);
    }
    
    public void open(int i, int j){          // open site (row i, column j) if it is not open already
    	validate(i, j);
    	openSta[(i - 1) * N + j] = true;
    	if (i == N) uf.union((i - 1) * N + j, N * N +1);
    	else if (i == 1){
    		uf.union(0, (i - 1) * N + j);
    		ufBackWash.union(0, (i - 1) * N + j);
    	}
    	int xi[] = {0, 0, -1, 1};
    	int yi[] = {-1, 1, 0, 0};
    	for (int dir = 0; dir < 4; dir ++){
    		int pox = i + xi[dir];
    		int poy = j + yi[dir];
    		if ( pox > 0 && pox < N +1 && poy > 0 && poy < N + 1 && isOpen(pox, poy)){
    			uf.union((pox - 1) * N + poy, (i - 1) * N + j);
        		ufBackWash.union((pox - 1) * N + poy, (i - 1) * N + j);
    		}
    	}
    }	
    
    public boolean isOpen(int i, int j){     // is site (row i, column j) open?
        validate(i, j);
        return openSta[(i - 1) * N + j];
    }
    
    private void validate(int i, int j) {
    	if (i < 1 || i > N) 
            throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j < 1 || j > N) 
            throw new IndexOutOfBoundsException("col index j out of bounds"); 
    }
    
    public boolean isFull(int i, int j) {    // is site (row i, column j) full?
    	validate(i, j);
    	return ufBackWash.find(0) == ufBackWash.find((i - 1) * N + j);
    }
    
    public boolean percolates() {            // does the system percolate?
    	return uf.find(0) == uf.find(N * N +1);   	
    }
    
    public static void main(String[] args){   // test client (optional)
        int Ni = 5;
    	Percolation p = new Percolation(Ni);
    	p.open(1,1);
    	p.open(1,2);
    	p.open(2,2);
    	p.open(3,2);
    	p.open(3,3);
    	p.open(4,3);
    	p.open(5,3);
    	System.out.println(p.percolates());
    }
}

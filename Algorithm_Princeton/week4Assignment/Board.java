package week4Assignment;

import edu.princeton.cs.algs4.Queue;

import java.util.*;

public class Board {
	
	private int N;
	private int[] boardNode;
	
	public Board(int[][] blocks)  {
		this.N = blocks.length;
		this.boardNode = new int[this.N * this.N];
		for (int i = 0; i < this.N * this.N; i++){
			boardNode[i] = blocks[i / this.N][(i % this.N)];
		}
	}   
	
    public int dimension()    {
		return this.N;
	}   // board dimension N
    
    public int hamming()        {
		int count = 0;
		for (int i = 0; i < this.N * this.N - 1; i++){
			if (this.boardNode[i] != i + 1){
				count++;
			}
		}
		return count;
	}   // number of blocks out of place
    
    public int manhattan()   {
		int count = 0, rowDis, colDis;
		for (int i = 0; i < this.N * this.N; i++){
			if (this.boardNode[i] != i + 1 && this.boardNode[i] != 0){
				colDis = (this.boardNode[i] - 1) % this.N - i % this.N; 
				rowDis = (this.boardNode[i] - 1) / this.N - i / this.N;
				colDis = colDis > 0 ? colDis : - colDis;
				rowDis = rowDis > 0 ? rowDis : - rowDis;
				count += colDis + rowDis;
			}
		}
		return count;
	}   // sum of Manhattan distances between blocks and goal
    
    public boolean isGoal()  {
    	for (int i = 0; i < this.N * this.N - 1; i++){
			if (this.boardNode[i] != i + 1){
				return false;
			}
		}
    	return true;
	}   // is this board the goal board?
    
    public Board twin() {
    	int[] newBoard = new int[this.N * this.N];
    	System.arraycopy(this.boardNode, 0, newBoard, 0, this.N * this.N);
    	if (newBoard[0] != 0 && newBoard[1] != 0){
    		newBoard[0] = this.boardNode[1];
    		newBoard[1] = this.boardNode[0];
    	}
    	else{
    		newBoard[N] = this.boardNode[N + 1];
    		newBoard[N + 1] = this.boardNode[N];
    	}
    	int[][] newNode = new int[this.N][this.N]; 
		for (int i = 0; i < this.N; i++){
			for (int j = 0; j < this.N; j++){
					newNode[i][j] = newBoard[i * this.N + j];
			}
		}
		Board twinBoard = new Board(newNode);
		return twinBoard;
	}   // a board that is obtained by exchanging two adjacent blocks in the same row
    
    public boolean equals(Object y) {
    	if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
    	Board compare = (Board) y;
    	if (compare.boardNode.length != this.boardNode.length) return false;
		for (int i = 0; i < this.N * this.N; i++){
			if (compare.boardNode[i] != this.boardNode[i])
				return false;
		}
		return true;
	}   // does this board equal y?
    
    public Iterable<Board> neighbors() {
    	Queue<Board> neigh = new Queue<Board>();
		int zeroPos = -1;
		int[][] genBoard = new int[this.N][this.N];
		for (int i = 0; i < this.N * this.N; i++){
			genBoard[i / this.N][i % this.N] = this.boardNode[i];
			if (this.boardNode[i] == 0){
				zeroPos = i;
				break;
			}
		}
		if (zeroPos == -1) return null;
		if (zeroPos / this.N != 0)  {
			Board swapUp = new Board(genBoard);
			System.arraycopy(this.boardNode,0,swapUp.boardNode,0,this.N * this.N); 
			swapUp.boardNode[zeroPos] = this.boardNode[zeroPos - this.N];
			swapUp.boardNode[zeroPos - this.N] = this.boardNode[zeroPos];
			neigh.enqueue(swapUp);
		}
		if (zeroPos / this.N != N - 1){
			Board swapDown = new Board(genBoard);
			System.arraycopy(this.boardNode,0,swapDown.boardNode,0,this.N * this.N); 
			swapDown.boardNode[zeroPos] = this.boardNode[zeroPos + this.N];
			swapDown.boardNode[zeroPos + this.N] = this.boardNode[zeroPos];
			neigh.enqueue(swapDown);
		}
		if (zeroPos % this.N != 0)  {
			Board swapLeft = new Board(genBoard);
			System.arraycopy(this.boardNode,0,swapLeft.boardNode,0,this.N * this.N); 
			swapLeft.boardNode[zeroPos] = this.boardNode[zeroPos - 1];
			swapLeft.boardNode[zeroPos - 1] = this.boardNode[zeroPos];
			neigh.enqueue(swapLeft);
		}
		if (zeroPos % this.N != N - 1)  {
			Board swapRight = new Board(genBoard);
			System.arraycopy(this.boardNode,0,swapRight.boardNode,0,this.N * this.N); 
			swapRight.boardNode[zeroPos] = this.boardNode[zeroPos + 1];
			swapRight.boardNode[zeroPos + 1] = this.boardNode[zeroPos];
			neigh.enqueue(swapRight);
		}
	    return neigh;
	}   // all neighboring boards   
    
    @Override
    public String toString() {
    	StringBuffer result = new StringBuffer();
    	result.append(this.N);
    	result.append("\n");
		for (int i = 0; i < this.N; i++){
			for (int j = 0; j < this.N; j++){
				result.append(" " + boardNode[i * this.N + j] + " ");
			}
			result.append("\n");
		}
		return result.toString();
	}   // string representation of this board (in the output format specified below)

    public static void main(String[] args) {
    	/**
    	int[][] test1 = {{1, 0}, {2, 3}};
		Board b1 = new Board(test1);
		System.out.println(b1);
		Iterable<Board> neighTest = b1.neighbors();
	    Iterator<Board> iter = neighTest.iterator();
	    while (iter.hasNext()){
	    	System.out.println("b1 has neighbor: ");
	    	System.out.println(iter.next());
	    }
	    Board b2 = b1.twin();
		System.out.println(b2.equals(b1));
		System.out.println(b2);
		**/
    	
    	int[][] test1 = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
		Board b1 = new Board(test1);
		System.out.println("Hamming num : " + b1.hamming());
		System.out.println("Manhattan num : " + b1.manhattan());
		System.out.println(b1.isGoal());
		System.out.println(b1);
		
		
		Board b2 = b1.twin();
		System.out.println(b2.equals(b1));
		System.out.println(b2);
		
		int[][] test2 = {{1, 2, 3}, {4, 5 ,6}, {7, 8, 0}};
		Board b3 = new Board(test2);
		System.out.println(b3.isGoal());
		System.out.println(b3);
		
		Iterable<Board> neighTest = b1.neighbors();
	    Iterator<Board> iter = neighTest.iterator();
	    while (iter.hasNext()){
	    	System.out.println("b1 has neighbor: ");
	    	System.out.println(iter.next());
	    }
	    
	}   // unit tests (not graded)
}

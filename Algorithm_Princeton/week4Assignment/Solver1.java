package week4Assignment;

import edu.princeton.cs.algs4.*;

/**
 * @author Downloaded From Internet
 * This is a version of sulution that is downloaded from Internet, 
 * with 100 score in the judgement system
 */
public class Solver1 {
    
    private Node root = new Node();
    private Node rootTwin = new Node();
    private MinPQ<Node> pq = new MinPQ<Node>();
    private MinPQ<Node> pqTwin = new MinPQ<Node>();
    private int moves = 0;
    private boolean solved;
    private Node lastnode = new Node();
    
    // find a solution to the initial board (using the A* algorithm)
    public Solver1(Board initial) {
        
        Node min;
        Node minTwin;
        Node newnode;
        Node newnodeTwin;
        
        // initialize root search node
        root.board = initial;
        root.moves = 0;
        root.prev = null;
        
        // initialize root search node twin
        rootTwin.board = initial.twin();
        rootTwin.moves = 0;
        rootTwin.prev = null;
        
        
        // insert root into priority queue
        pq.insert(root);
        //StdOut.print("Root:\n");
        //StdOut.print(root.board.toString());
        pqTwin.insert(rootTwin);
        //StdOut.print("Twin:\n");
        //StdOut.print(rootTwin.board.toString());
        
        min = pq.delMin();
        lastnode = min;
        minTwin = pqTwin.delMin();
        if (min.board.isGoal()) solved = true;
        if (minTwin.board.isGoal()) solved = false;
        //StdOut.print("Root:\n");
        //StdOut.print(min.board.toString());

        while (!min.board.isGoal() && !minTwin.board.isGoal()) {  // run until we find a solution
            
            for (Board neighbor : min.board.neighbors()) {        // loop through neighbours
                
                if (min.prev != null) {
                    if (neighbor.equals(min.prev.board)) {
                        //StdOut.print("Saved memory!\n");
                        continue;                                 // critical optimization
                    }
                }
                newnode = new Node();
                newnode.board = neighbor;          // set the neighbor
                newnode.moves = min.moves + 1;     // set the moves
                newnode.prev = min;           // link to previous node
                pq.insert(newnode);
                //StdOut.print("New neighbor enlisted:\n");
                //StdOut.print(neighbor.toString());
                //StdOut.print("Manhattan: " + neighbor.manhattan() + "\n");
                //StdOut.print("Moves: " + newnode.moves + "\n");
                
            }
            
            for (Board neighborTwin : minTwin.board.neighbors())   {
                
                if (minTwin.prev != null) {
                    if (neighborTwin.equals(minTwin.prev.board)) {
                        continue;                  // critical optimization
                    }
                }
                
                newnode = new Node();
                newnode.board = neighborTwin;          // set the neighbor
                newnode.moves = minTwin.moves + 1;     // set the moves
                newnode.prev = minTwin;           // link to previous node
                pqTwin.insert(newnode);
                
            } 
            
            min = pq.delMin();                 // delete search node with min priority
            lastnode = min;
            //StdOut.print("current :");
            //StdOut.print(lastnode.board.toString());
            if (min.board.isGoal()) {
                solved = true;
                moves = lastnode.moves;
            }
            
            minTwin = pqTwin.delMin();       // delete search node with min priority
            if (minTwin.board.isGoal()) solved = false;
            //StdOut.print("Minimum was deleted:\n");
            //StdOut.print(min.board.toString());
        }
        
    }
    
    // helper node class
    private class Node implements Comparable<Node> {
        private Board board;
        private int moves;
        private Node prev;
        
        public int compareTo(Node that) {
            if (this.moves + this.board.manhattan() < that.moves + that.board.manhattan()) return -1;
            if (this.moves + this.board.manhattan() > that.moves + that.board.manhattan()) return +1;
            else return 0;
        }
    }
    
    // is the initial board solvable?
    public boolean isSolvable() {
        return solved;
    }
    
    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!this.isSolvable()) return -1;
        else                    return moves;
    }                     
    
    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        Node current = lastnode;
        if (this.isSolvable()) {
            Stack<Board> n = new Stack<Board>();
            while (current != null) {
                n.push(current.board);
                current = current.prev;
            }
            return n;
        }
        else return null;
    }      
    
    // solve a slider puzzle (given below)
    public static void main(String[] args) {
    	
    	int[][] test0 = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
		Board b0 = new Board(test0);
		Solver1 solveB0 = new Solver1(b0);
		System.out.println(solveB0.isSolvable());
		System.out.println(solveB0.moves());
		for (Board board : solveB0.solution())
            System.out.println(board);
        
    	
    	
    	int[][] test1 = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
		Board b1 = new Board(test1);
		Solver1 solveB1 = new Solver1(b1);
		System.out.println(solveB1.isSolvable());
		System.out.println(solveB1.moves());
		for (Board board : solveB1.solution())
            System.out.println(board);
    	
		int[][] test2 = {{1, 2, 3}, {4, 5, 6}, {8, 7, 0}};
		Board b2 = new Board(test2);
		Solver1 solveB2 = new Solver1(b2);
		System.out.println(solveB2.isSolvable());
		System.out.println(solveB2.moves());
		
    	/**
        // create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
            blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        
        // solve the puzzle
        Solver1 solver = new Solver1(initial);
        
        
        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
        **/
    } 
}
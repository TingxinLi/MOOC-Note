package week4Assignment;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

public class Solver {
	
	private SearchNode solution;
	private boolean solved;
	private int gameMove = -1;		
	 
	private class SearchNode implements Comparable<SearchNode>{
		private int moves;
		private Board board;
		private SearchNode pre;
		
		public SearchNode(Board b){
			this.moves = 0;
			this.pre = null;
			this.board = b;
		}

		@Override
		public int compareTo(SearchNode that) {
			int manPriority1 = this.board.manhattan() + this.moves;
			int manPriority2 = that.board.manhattan() + that.moves;
			if (manPriority1 > manPriority2) return 1;
			else if (manPriority1 < manPriority2) return -1;
			else return 0;
		}

	}
		
	public Solver(Board initial) {
		solved = false;
		
		SearchNode node = new SearchNode(initial);
		SearchNode twinNode = new SearchNode(initial.twin());
		MinPQ<SearchNode> pq = new MinPQ<SearchNode>();		
	    MinPQ<SearchNode> twinPQ = new MinPQ<SearchNode>();
	    
		if (node.board.isGoal()) {
			solved = true;
			solution = node;
			gameMove = 0;
		}
		if (twinNode.board.isGoal()) {
			solved = false;
		}
		
		while (!node.board.isGoal() && !twinNode.board.isGoal()){
			
			for (Board neigh : node.board.neighbors()){	
				if (node.pre != null && neigh.equals(node.pre.board)){
					continue;
				}
				SearchNode neighNode = new SearchNode(neigh);
				neighNode.moves = node.moves + 1;
				neighNode.pre = node;
				pq.insert(neighNode);
			}
			node = pq.delMin();

			if (node.board.isGoal()) {
				solved = true;
				solution = node;
				gameMove = solution.moves;
			}
			
			for (Board neighTwin : twinNode.board.neighbors()){	
				if (twinNode.pre != null && neighTwin.equals(twinNode.pre.board)){
					continue;
				}
				SearchNode neighNode = new SearchNode(neighTwin);
				neighNode.moves = twinNode.moves + 1;
				neighNode.pre = twinNode;
				twinPQ.insert(neighNode);
			}
			twinNode = twinPQ.delMin();
			
		}
	} // find a solution to the initial board (using the A* algorithm)
	
    public boolean isSolvable()   {
    	return solved;
    } // is the initial board solvable?
    
    public int moves()  {
    	return gameMove;
    } // min number of moves to solve initial board; -1 if unsolvable
    
    public Iterable<Board> solution()  {
    	if (!solved) return null;
    	SearchNode ans = solution;
    	Stack<Board> sol = new Stack<Board>();
		while (ans != null){
			sol.push(ans.board);
			ans = ans.pre;
		}
	    return sol;
    }    // sequence of boards in a shortest solution; null if unsolvable
    
    public static void main(String[] args) {
    	
    	int[][] test0 = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
		Board b0 = new Board(test0);
		Solver solveB0 = new Solver(b0);
		System.out.println(solveB0.isSolvable());
		System.out.println(solveB0.moves());
		//for (Board board : solveB0.solution())
            //System.out.println(board);
		solveB0.solution();
		Stack<Board> so = (Stack<Board>)solveB0.solution();
        System.out.println(so.size());
    	
    	
    	int[][] test1 = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
		Board b1 = new Board(test1);
		Solver solveB1 = new Solver(b1);
		System.out.println(solveB1.isSolvable());
		System.out.println(solveB1.moves());
		//for (Board board : solveB1.solution())
            //System.out.println(board);
		Stack<Board> so1 = (Stack<Board>)solveB1.solution();
        System.out.println(so1.size());
		
    	
		
		int[][] test2 = {{1, 2, 3}, {4, 5, 6}, {8, 7, 0}};
		Board b2 = new Board(test2);
		Solver solveB2 = new Solver(b2);
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
	    Solver solver = new Solver(initial);

	    // print solution to standard output
	    if (!solver.isSolvable())
	        StdOut.println("No solution possible");
	    else {
	        StdOut.println("Minimum number of moves = " + solver.moves());
	        for (Board board : solver.solution())
	            StdOut.println(board);
	    }**/
    }// solve a slider puzzle (given below)
}

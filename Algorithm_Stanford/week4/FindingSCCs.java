package week4;
import java.io.File;
import java.util.*;

/**
 * @author Travis
 * StackOverFlowError for big data, not fixed yet.
 */
public class FindingSCCs {
	private int[] result;
	private boolean[] marked, newMarked;
	private Stack<Integer> trace;
	private int[] order;
	private int count, countSCC;
	
	public FindingSCCs(Graph input) {
		this.result = new int[5];
		this.marked = new boolean[input.V()];
		this.trace = new Stack<Integer>();
		this.order = new int[input.V()];
		this.count = 0;
		Graph rever = input.reverse();
		//System.out.println(rever);
		
		for (int i = 1; i <= order.length; i++){
			if (!marked[i - 1]){
				trace.push(i);
				subFinding(rever, trace.peek());
			}
		}
		//for (boolean b : marked)  System.out.println(b);
		//for (int i : order)       System.out.print(i + "  ");
		//System.out.println();
		//System.out.println("Count = " + count);
		
		this.trace = new Stack<Integer>();
		this.newMarked = new boolean[this.marked.length];
		int[] newOrder = new int[order.length];
		this.countSCC = 0;
		for (int i = 0; i < order.length; i++) { newOrder[order[i] - 1] = i + 1; }
		//for (int i : newOrder) System.out.print(i + "  ");
		System.out.println();
		for (int i = newOrder.length; i > 0; i--){
			//System.out.println("Been find started by: " + newOrder[i - 1]);
			if (newMarked[newOrder[i - 1] - 1]) {
				continue;
			}
			trace.push(newOrder[i - 1]);
			subFindScc(input, trace.peek());
		}
	}
	
	private void subFindScc(Graph input, int v){
		this.countSCC++;
		if (checkNewEnd(input, v)){
			trace.pop();
			newMarked[v - 1] = true;
			foundNewScc();
			return;
		}
		//System.out.println("Second round, V is: " + v);
		if (newMarked[v - 1]){
			if (trace.isEmpty()){
				return;
			}
			subFindScc(input, trace.pop());
			return;
		}
	    newMarked[v - 1] = true;
	    LinkedList<Integer> temp = input.getNextVertex(v);
		for (int w : temp){
			if (!newMarked[w - 1]){
				trace.push(w);
			}
		}
		if (!trace.isEmpty()){
			subFindScc(input, trace.peek());
		}
	}
	
	private void subFinding(Graph input, int v){
		if (checkEnd(input, v)){
			if (!marked[v - 1]) marked[v - 1] = true;
			trace.pop();
		}
		//System.out.println("V is: " + v);
		if (marked[v - 1]){
			if (trace.isEmpty()){
				return;
			}
			subFinding(input, trace.peek());
			return;
		}
		marked[v - 1] = true;
		LinkedList<Integer> temp = input.getNextVertex(v);
		for (int w : temp){
			if (!marked[w - 1]){
				trace.push(w);
			}
		}
		if (!trace.isEmpty()){
			subFinding(input, trace.peek());
		}
	}
	
	private boolean checkNewEnd(Graph g, int v){
		LinkedList<Integer> nextVertex = g.getNextVertex(v);
		boolean isNewEnd = true;
		for (int w : nextVertex){
			if (!newMarked[w - 1]){
				isNewEnd = false;
			}
		}
		return isNewEnd;
	}
	
	private boolean checkEnd(Graph g, int v){
		LinkedList<Integer> nextVertex = g.getNextVertex(v);
		boolean isEnd = true;
		for (int w : nextVertex){
			//System.out.println(v + " has next: " + w);
			if (!marked[w - 1]){
				isEnd = false;
			}
		}
		if (isEnd){
			//for (boolean b : marked) System.out.print(b + "  ");
			if (order[v - 1] == 0){
				order[v - 1] = ++count;
			}
		}
		return isEnd;
	}
	
	private void foundNewScc(){
		int newSize = this.countSCC;
		System.out.println("Found new SCC with size of: " + newSize);
		int minPo = 0;
		this.countSCC = 0;
		boolean isFull = true;
		for (int i = 0; i < 5; i++){
			if (result[i] == 0){
				result[i] = newSize;
				isFull = false;
				break;
			}
			if (result[i] < result[minPo]){
				
			}
		}
		if (isFull){
			result[minPo] = newSize > result[minPo] ? newSize : result[minPo];
		}
	}
	
	public String toString(){
		StringBuffer output = new StringBuffer();
		for(int i = 0; i < 5; i++){
			output.append(this.result[i] + "  ");
		}
		output.append("\n");
		return output.toString();
	}
	
	public static void main(String[] args) {
		/**
		File file1=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week4/text1.txt");
        Graph G = new Graph(9);
        G = G.GraphIn(G, 9, file1);
        System.out.println(G);
        FindingSCCs fscc = new FindingSCCs(G);
		System.out.println(fscc);
		**/
		
		/**
		File file2=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week4/text2.txt");
        Graph G1 = new Graph(8);
        G1 = G1.GraphIn(G1, 8, file2);
        System.out.println(G1);
        FindingSCCs fscc1 = new FindingSCCs(G1);
		System.out.println(fscc1);
		**/
		
		
		File file3=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week4/text3.txt");
        Graph G2 = new Graph(12);
        G2 = G2.GraphIn(G2, 12, file3);
        System.out.println(G2);
        FindingSCCs fscc2 = new FindingSCCs(G2);
		System.out.println(fscc2);
		
		/**
		File file3=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week4/SCC.txt");
        Graph G2 = new Graph(875714);
        G2 = G2.GraphIn(G2, 875714, file3);
        //System.out.println(G2);
        FindingSCCs fscc2 = new FindingSCCs(G2);
		System.out.println(fscc2);
		**/
	}
}

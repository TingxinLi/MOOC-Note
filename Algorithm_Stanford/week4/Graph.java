package week4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;
import java.lang.Exception;

/**
 * @author Travis
 * Directed Graph
 */
public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;
    private String encoding="GBK";
    
    
	/**
	 * Initialized an empty graph with the input size
	 * @param size the number of vertices
	 */
	@SuppressWarnings("unchecked")
	public Graph(int size){
		this.V = size;
        this.E = 0;
        this.adj = (LinkedList<Integer>[]) new LinkedList[size];
        
        for (int i = 0; i < V; i++){
        	adj[i] = new LinkedList<Integer>();
        }
	}
	
	/**
     * Instantiate an graph with the data from the input file
     */
	public Graph GraphIn(Graph graph, int size, File file) {
        try {  
            if(file.isFile() && file.exists()){ //Ensure that file exists
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	String[] arr=lineTxt.split("\\s+");
                	graph.addEdge(Integer.parseInt(arr[0]) - 1, Integer.parseInt(arr[1]));
                }
                read.close();
                int doubleE = 0;
                for (int i = 0; i < V; i++){
                	doubleE += graph.adj[i].size();
                }
                E = doubleE;
            }else{
            	System.out.println("File not found.");
            }
		} catch (Exception e) {
			System.out.println("Error exist while reading.");
			e.printStackTrace();
		}
        
        if (V != size) System.out.println("Vertex size not equal to input size!!!!!!!");
        return graph;
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    // throw an IndexOutOfBoundsException unless 0 <= v < V + 1
    private void validateVertex(int v) {
        if (v < 0 || v > V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Adds the directed edge v-w to the graph.
     * @param v one vertex in the edge
     * @param w the other vertex in the edge
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
    }

    public void delEdge(int v, int w){
    	validateVertex(v);
        validateVertex(w);
        E--;
        adj[v].removeFirstOccurrence(w);
    }
    
    /**
     * Returns the vertices adjacent to vertex <tt>v</tt>.
     * @param v the vertex
     * @return the vertices adjacent to vertex <tt>v</tt> as an Iterable
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex <tt>v</tt>.
     * @param v the vertex
     * @return the degree of vertex <tt>v</tt>
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
     */
    public int degree(int v) {
        validateVertex(v);
        return this.adj[v - 1].size();
    }

    public LinkedList<Integer> getNextVertex(int v){
    	return this.adj[v - 1];
    }
    
    /**
     * Returns a string representation of the graph.
     * This method takes time proportional to E + V<.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + 1 + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public boolean isEmpty(int v){
    	return this.adj[v].size() == 0;
    }
    
	public Graph reverse(){
    	Graph reverse = new Graph(V);
    	for (int i = 0; i < this.V; i++){
    		for(int j = 0; j < adj[i].size(); j++){
    			reverse.addEdge(adj[i].get(j) - 1, i + 1);
    		}
    	}
    	return reverse;
    }
	
    public int ContractGraph(int trailNum){
    	int minCut = E;
    	for (int i = 0; i < trailNum; i++){
    		int temp = subContractGraph();
    		if (minCut > temp)
    			minCut = temp;
    	}
    	return minCut;
    }
    
    @SuppressWarnings("unchecked")
	private int subContractGraph(){
    	int subV = V;
    	LinkedList<Integer>[] subAdj =(LinkedList<Integer>[]) new LinkedList[V];
    	boolean[] beenDel = new boolean[V];
    	Random ran = new Random();
    	for (int i = 0; i < V; i++){
    		subAdj[i] = new LinkedList<Integer>(adj[i]);
    	}//Deep copy graph and generate the array for contract algorithm
    	
    	while ( subV-- > 2){
    		int ranU = ran.nextInt(V) + 1; // choose a random vertex U
    		while (beenDel[ranU - 1]) ranU = ran.nextInt(V) + 1; 
    		int ranV = subAdj[ranU - 1].get(ran.nextInt(subAdj[ranU - 1].size()));
    		for (int s : subAdj[ranU - 1]){
    			if (s != ranV){
    				subAdj[s - 1].removeFirstOccurrence(ranU);
    				subAdj[s - 1].add(ranV);
    				subAdj[ranV - 1].add(s);
    			}
    			else {
    				subAdj[ranV - 1].removeFirstOccurrence(ranU);
    			}
     		}
    		beenDel[ranU - 1] = true;
    	} 
     
    	int result[] = new int[2];
    	int count = 0;
    	for (int i = 0; i < V; i++){
    		if (!beenDel[i]) result[count++] = subAdj[i].size();
    	}
    	if (result[0] != result[1]) System.out.println("Error!!!!!!!!!!!!");
    	return result[0];
    }

    // Unit tests
    public static void main(String[] args) {
        
    	File file1=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week4/text1.txt");
        Graph G = new Graph(9);
        G = G.GraphIn(G, 9, file1);
        System.out.println(G);
	
		Graph ReverseG = G.reverse();
		System.out.println("Reverse of G: " + ReverseG);
		
    	File file2=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week4/text2.txt");
        Graph G1 = new Graph(8);  
        G1 = G1.GraphIn(G1, 8, file2);
        System.out.println(G1);
		
		Graph ReverseG1 = G1.reverse();
		System.out.println("Reverse of G2: " + ReverseG1);

    }
}


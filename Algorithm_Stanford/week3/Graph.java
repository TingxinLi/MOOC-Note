package week3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;
import java.lang.Exception;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;
    private String encoding="GBK";
    
    /**
     * Initializes an empty graph with <tt>V</tt> vertices and 0 edges.
     * param size the number of vertices
     */
	@SuppressWarnings("unchecked")
	public Graph(int size, File file) {
        V = 0;
        E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[size] ; 
        

        try {  
            if(file.isFile() && file.exists()){ //Ensure that file exists
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	adj[V] = new LinkedList<Integer>();
                	String[] arr=lineTxt.split("\\s+");
                	for (int i = 1; i < arr.length; i++){
                		adj[V].add(Integer.parseInt(arr[i]));
                	}
                	V++;
                }
                read.close();
                int doubleE = 0;
                for (int i = 0; i < V; i++){
                	doubleE += adj[i].size();
                }
                // check whether graph is valid or not
                if (doubleE % 2 != 0)  
                	throw new Exception("Unvalid input graph!!!!!!!!!!!!!!!!!!");
                else 
                	E = doubleE / 2;
            }else{
            	System.out.println("File not found.");
            }
		} catch (Exception e) {
			System.out.println("Error exist while reading.");
			e.printStackTrace();
		}
        
        if (V != size) System.out.println("Vertex size not equal to input size!!!!!!!");
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Adds the undirected edge v-w to the graph.
     * @param v one vertex in the edge
     * @param w the other vertex in the edge
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
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
        return adj[v].size();
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
        
    	File file1=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week3/text2.txt");
        Graph G = new Graph(4, file1);  
        //System.out.println(G);
		System.out.println("Min cut for ex1: " + G.ContractGraph(16));
		
		File file2=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week3/text1.txt");
        Graph G2 = new Graph(8, file2);  
        //System.out.println(G2);
		System.out.println("Min cut for ex2: " + G2.ContractGraph(16));
		
		File file3=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week3/text3.txt");
        Graph G3 = new Graph(40, file3);  
        //System.out.println(G3);
		System.out.println("Min cut for ex3: " + G3.ContractGraph(40));
		
		File file4=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week3/kargerMinCut.txt");
        Graph G4 = new Graph(200, file4);  
        //System.out.println(G3);
		System.out.println("Min cut for ex4: " + G4.ContractGraph(400));
    }
}


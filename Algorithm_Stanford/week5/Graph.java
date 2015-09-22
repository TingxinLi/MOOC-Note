package week5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Exception;

/**
 * @author Travis
 * Directed Graph with non-negative-length edges
 */
public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;
    private ArrayList<Node> vertex;
    private String encoding="GBK";
    
    
    class Node{
    	private int num;
    	private int dis;
    	private boolean found;
    	private Hashtable<Integer, Integer> edge;
    	
    	public Node(int num, int dis){
    	    this.num = num;
    	    this.dis = dis;
    	    this.found = false;
    	    edge = new Hashtable<Integer, Integer>();
    	}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getDis() {
			return dis;
		}

		public void setDis(int dis) {
			this.dis = dis;
		}
		
        public int getLength(int key){
        	return this.edge.get(key);
        }
		
		public boolean isFound() {
			return found;
		}
		

		public void setFound(boolean found) {
			this.found = found;
		}
    	
    	public void addEdge(int key, int length){
    		this.edge.put(key, length);
    	}
    	
    	public int[] getAllDirectedVertex(){
    		Iterator<Integer> itr = this.edge.keySet().iterator();
    		int[] keys = new int[this.edge.size()];
    		int count = 0;
    		while(itr.hasNext()){
    			keys[count++] = itr.next();
    		}
    		return keys;
    	}
    	
    	public Hashtable<Integer, Integer> getSumDistance(){
    		Hashtable<Integer, Integer> sumDis = new Hashtable<Integer, Integer>();
    		int[] keys = getAllDirectedVertex();
    		for(int i = 0; i < keys.length; i++){  
                sumDis.put(keys[i], this.edge.get(keys[i]) + getDis());
            }  
    		return sumDis;
    	}
    	
    }
    
	/**
	 * Initialized an empty graph with the input size
	 * @param size the number of vertices
	 */
	public Graph(int size){
		this.V = size;
        this.vertex = new ArrayList<Node>();
        
        for(int i = 0; i < size; i++){
        	Node newNode = new Node(i+1, 0);
        	vertex.add(newNode);
        }
	}
	

    //Instantiate an graph with the data from the input file
	public void GraphIn(int size, File file) {
        try {  
            if(file.isFile() && file.exists()){ //Ensure that file exists
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	String[] arr = lineTxt.split("\\s+");
                	int line = Integer.parseInt(arr[0]);
                	for (int i = 1; i < arr.length; i++){
                		String[] pair = arr[i].split(",");
                		vertex.get(line - 1).addEdge(Integer.parseInt(pair[0]), Integer.parseInt(pair[1]));
                	}
                }
                read.close();
            }else{
            	System.out.println("File not found.");
            }
		} catch (Exception e) {
			System.out.println("Error exist while reading.");
			e.printStackTrace();
		}
        
        if (this.V != size) System.out.println("Vertex size not equal to input size!!!!!!!");
    }

    public int V() {
        return this.V;
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
    public void addEdge(int v, int w, int length) {
        validateVertex(v);
        validateVertex(w);
        vertex.get(v).addEdge(w, length);
    }

    /**
     * Returns a string representation of the graph.
     * This method takes time proportional to E + V<.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices: " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(vertex.get(v).getNum() + ": ");
            for (int w : vertex.get(v).getAllDirectedVertex()) {
                s.append(w + "," + vertex.get(v).getLength(w) + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public boolean isEmpty(int v){
    	return vertex.get(v).getAllDirectedVertex().length == 0;
    }

    public Node getNode(int v){
    	return vertex.get(v);
    }

    // Unit tests
    public static void main(String[] args) {
        
    	File file1=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week5/text1.txt");
        Graph G1 = new Graph(4);
        G1.GraphIn(4, file1);
        System.out.println(G1);
	
		
    	File file2=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week5/text2.txt");
        Graph G2 = new Graph(7);  
        G2.GraphIn(7, file2);
        System.out.println(G2);
		
        File file3=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week5/text3.txt");
        Graph G3 = new Graph(4);  
        G3.GraphIn(4, file3);
        System.out.println(G3);
        
        File file4=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week5/dijkstraData.txt");
        Graph G4 = new Graph(200);  
        G4.GraphIn(200, file4);
        System.out.println(G4);
    }
}


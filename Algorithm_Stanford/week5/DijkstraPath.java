package week5;

import java.io.File;
import java.util.*;

public class DijkstraPath {

	private int[] result;
	
	public DijkstraPath(Graph g){
		result = new int[g.V()];
		//int edgeFrom;
		int edgeTo;
		int minDis;
		int[] keys;
		Hashtable<Integer, Integer> pairs;
		List<Integer> beenTo = new ArrayList<Integer>();
		int trace = 1;
		
		while(beenTo.size() < result.length - 1){
			if (g.getNode(trace - 1).isFound())   System.out.println("!!!!!!ERROR!!!!!!!!");
			
			g.getNode(trace - 1).setFound(true);
			beenTo.add(trace);
			minDis = Integer.MAX_VALUE;
			edgeTo = -1;
			
			for (int i : beenTo){
				//System.out.println("beenTO: " + i);
				
				pairs = g.getNode(i - 1).getSumDistance();
				keys = g.getNode(i - 1).getAllDirectedVertex();
				for (int j = 0; j < pairs.size(); j++){
					if (g.getNode(keys[j] - 1).isFound()){
						continue;
					}
					if (pairs.get(keys[j]) < minDis){
						//edgeFrom = i;
						edgeTo = keys[j];
						minDis = pairs.get(keys[j]);
					}
				}
			}
			
			g.getNode(edgeTo - 1).setDis(minDis);
			trace = edgeTo;
		}
		
		for (int i = 0; i < result.length; i++){
			result[i] = g.getNode(i).getDis();
		}
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Dijkstra's shortest-path of the graph are: \n");
		for(int i = 0; i < result.length; i++){
			sb.append(i + 1 + ": " + result[i] + "\n");
		}
		return sb.toString();
	}
	
	public int[] solution(){
		return this.result;
	}
	
	public static void main(String[] args) {
		File file1=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week5/text1.txt");
        Graph G1 = new Graph(4);
        G1.GraphIn(4, file1);
        System.out.println(G1);
		DijkstraPath dp = new DijkstraPath(G1);
		System.out.println(dp);
		
		File file2=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week5/text2.txt");
        Graph G2 = new Graph(7);  
        G2.GraphIn(7, file2);
        System.out.println(G2);
        DijkstraPath dp2 = new DijkstraPath(G2);
		System.out.println(dp2);
		
		File file3=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week5/text3.txt");
        Graph G3 = new Graph(4);  
        G3.GraphIn(4, file3);
        System.out.println(G3);
        DijkstraPath dp3 = new DijkstraPath(G3);
		System.out.println(dp3);
		
		File file4=new File("/Users/Travis/Documents/workspace/AlgorStanford/src/week5/dijkstraData.txt");
        Graph G4 = new Graph(200);  
        G4.GraphIn(200, file4);
        System.out.println(G4);
        DijkstraPath dp4 = new DijkstraPath(G4);
		System.out.println(dp4);
	}
}

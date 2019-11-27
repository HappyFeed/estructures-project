package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.AdjListGraph;
import model.Vertex;

public class Main { 

	  
    public static void main(String args[]) throws IOException 
    { 
  
        // Object of graph is created. 
    	AdjListGraph<Integer> g = new AdjListGraph<Integer>(false, false); 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] nQ = br.readLine().split(" ");
    	
    	int nodes = Integer.parseInt(nQ[0]);
    	int queries = Integer.parseInt(nQ[1]);
    	
    	for (int i = 0; i < queries; i++) {
			String[] vertex = br.readLine().split(" ");
			int val1 = Integer.parseInt(vertex[0]);
			int val2 = Integer.parseInt(vertex[1]);
			
			Vertex<Integer> v1 = new Vertex<Integer>(val1);
			Vertex<Integer> v2 = new Vertex<Integer>(val2);
			g.addVertex(v1.getValue());
			g.addVertex(v2.getValue());
		}
        // edges are added. 
        // Since the graph is bidirectional, 
        // so boolean bidirectional is passed as true. 
        g.addEdge(0, 1, 1); 
        g.addEdge(0, 4, 2); 
        g.addEdge(1, 2, 1); 
        g.addEdge(1, 3, 2); 
        g.addEdge(1, 4, 1); 
        g.addEdge(2, 3, 1); 
        g.addEdge(3, 4, 4); 
  
        // print the graph. 
        System.out.println("Graph:\n"
                           + g.toString()); 
  
        // gives the no of vertices in the graph. 
        g.getNumberOfVertices(); 
  
        // gives the no of edges in the graph. 
        g.getNumberOfEdges(); 
  
        // tells whether the edge is present or not. 
        g.areAdjacent(g.searchVertex(3), g.searchVertex(4)); 
  
        // tells whether vertex is present or not 
        g.searchVertex(5); 
        
        Vertex<Integer> v = g.searchVertex(3);
        g.dijkstra(v, 4);
    } 
    
}

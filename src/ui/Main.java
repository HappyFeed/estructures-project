package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.AdjListGraph;
import model.Vertex;
import model.Edge;

public class Main { 

	  
    public static void main(String args[]) throws IOException 
    { 
  
        // Object of graph is created. 
    	AdjListGraph<Integer> g = new AdjListGraph<Integer>(false, true); 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] nQ = br.readLine().split(" ");
    	
    	int nodes = Integer.parseInt(nQ[0]);
    	for (int i = 0; i < nodes; i++) {
    		Vertex<Integer> newVertex = new Vertex<Integer>(i+1);
    		g.addVertex(newVertex.getValue());
		}
    	int queries = Integer.parseInt(nQ[1]);
    	
    	for (int i = 0; i < queries; i++) {
			String[] vertex = br.readLine().split(" ");
			int val1 = Integer.parseInt(vertex[0]);
			int val2 = Integer.parseInt(vertex[1]);
			
			g.addEdge(val1, val2, 1);
			Edge<Integer> e = new Edge<Integer>(g.getVertices().get(val1-1), g.getVertices().get(val2-1), 0);
			g.getEdgeCount().add(e);
		}
    	
    	for (int i = 0; i < queries; i++) {
    		String line = br.readLine();
    		int value = Integer.parseInt(line);
		}
    	
    	br.close();
    	for (int i = 0; i < g.getVertices().size(); i++) {
    		g.dijkstra(g.getVertices().get(i),1);		
		}
    	
    	for (int i = 0; i < g.getEdgeCount().size(); i++) {
			System.out.println(g.getEdgeCount().get(i).getTimes());
		}
    	//g.floydwarshall();
    	

    	
        // edges are added. 
        // Since the graph is bidirectional, 
        // so boolean bidirectional is passed as true. 
       /* g.addEdge(0, 1, 1); 
        g.addEdge(0, 4, 1); 
        g.addEdge(1, 2, 1); 
        g.addEdge(1, 3, 1); 
        g.addEdge(1, 4, 1); 
        g.addEdge(2, 3, 1); 
        g.addEdge(3, 4, 1); */
  
        // print the graph. 
    	
    	
    	/*
    	 * 
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
        
        */
    } 
    
}

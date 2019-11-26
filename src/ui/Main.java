package ui;

import model.AdjListGraph;

public class Main { 
	  
    public static void main(String args[]) 
    { 
  
        // Object of graph is created. 
    	AdjListGraph<Integer> g = new AdjListGraph<Integer>(false, false); 
  
        // edges are added. 
        // Since the graph is bidirectional, 
        // so boolean bidirectional is passed as true. 
        g.addEdge(0, 1); 
        g.addEdge(0, 4); 
        g.addEdge(1, 2); 
        g.addEdge(1, 3); 
        g.addEdge(1, 4); 
        g.addEdge(2, 3); 
        g.addEdge(3, 4); 
  
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
    } 
} 
package ui;

import model.Graph;

public class Main { 
	  	
	public static void main(String [] args) {
		Graph<Integer> g= new Graph<Integer>(true);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		g.connect(1, 3, -2);
		g.connect(3, 4, 2);
		g.connect(4, 2, -1);
		g.connect(2, 3, 3);
		g.connect(2, 1, 4);
		g.floydWarshall();
	}

} 
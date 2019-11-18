package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Graph.Node;

class GraphTest {

	Graph<Integer> g;
	
	public void setUp1() {
		g= new Graph<Integer>();
	}
	
	public void setUp2() {
		g= new Graph<Integer>();
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
	}
	
	public void setUp3() {
		g= new Graph<Integer>();
		for (int i = 0; i <= 5; i++) {
			g.addNode(i);
		}
		g.connect(0, 1, 1);	
		g.connect(0, 2, 1);	
		g.connect(1, 3, 1);	
		g.connect(1, 4, 1);	
		g.connect(2, 3, 1);	
		g.connect(3, 5, 1);	
		g.connect(4, 5, 1);	

	}
	
	@Test
	void constructorTest() {
		setUp1();		
		List<Graph<Integer>.Node> n= g.getNodes();
		assertNotNull(n);
		
	}
	
	@Test
	void addTest() {
		setUp1();	
		int node1 = 1;
		int node2 = 2;
		int node3 = 3;
		int node4 = 4;
		
		g.addNode(node1);
		g.addNode(node2);
		g.addNode(node3);
		g.addNode(node4);
		assertTrue("Method fail in value "+1,g.getNodes().get(1).getValue()==1);
		assertTrue("Method fail in value "+2,g.getNodes().get(2).getValue()==2);
		assertTrue("Method fail in value "+3,g.getNodes().get(3).getValue()==3);
		assertTrue("Method fail in value "+4,g.getNodes().get(4).getValue()==4);
	}

	@Test
	void connectTest() {
		setUp2();	
		g.connect(1, 3, 5);	
		assertTrue("Method fail in: "+1+" to "+3,g.getNodes().get(1).edges.containsKey(3));
		assertTrue("Method fail in: "+3+" to "+1,g.getNodes().get(3).edges.containsKey(1));
		assertTrue("Method fail in the weight: "+1+" to "+3,g.getNodes().get(1).edges.containsValue(5));
		assertTrue("Method fail in the weight: "+3+" to "+1,g.getNodes().get(3).edges.containsValue(5));
		g.connect(2, 4, 10);
		assertTrue("Method fail in: "+2+" to "+4,g.getNodes().get(2).edges.containsKey(4));
		assertTrue("Method fail in: "+4+" to "+2,g.getNodes().get(4).edges.containsKey(2));
		assertTrue("Method fail in the weight: "+2+" to "+4,g.getNodes().get(2).edges.containsValue(10));
		assertTrue("Method fail in the weight: "+4+" to "+2,g.getNodes().get(4).edges.containsValue(10));
	}
		

	
}

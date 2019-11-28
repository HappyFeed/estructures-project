package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AdjMatrixGraphTest {
	
	private AdjMatrixGraph<Integer> ag;
	
	private void setUp1() {
		
	}
	
	private void setUp2(){
		
		ag = new AdjMatrixGraph<Integer>(false, false);
	}

	@Test
	public void constructorTest() {
		setUp1();
		boolean directed = false;
		boolean weighted = false;
		
		ag = new AdjMatrixGraph<Integer>(directed, weighted);
		
		assertTrue("the graph couldn't be created", ag != null);
		assertTrue("the graph couldn't be created", ag.getEdges() == null);
		assertTrue("the graph couldn't be created", ag.getVertices() == null);
		assertTrue("the graph couldn't be created", ag.getNumberOfEdges() == 0);

	}
	
	@Test
	public void addVertexTest() {
		setUp2();
		int valueVer = 2;
		int valueVer2 = 5;
		
		ag.addVertex(valueVer);
		ag.addVertex(valueVer2);
		
		assertTrue("The vertex were not added", ag.getNumberOfVertices() != 0);
		
	}
	
	@Test
	public void addEdgeTest() {
		setUp2();
		int valueVer = 3;
		int valueVer2 = 6;
		int valueVer3 = 2;
		int valueVer4 = 4;
		double weight = 1;
		
		Vertex<Integer> v1 = new Vertex<Integer>(valueVer);
		Vertex<Integer> v2 = new Vertex<Integer>(valueVer2);
		Vertex<Integer> v3 = new Vertex<Integer>(valueVer3);
		Vertex<Integer> v4 = new Vertex<Integer>(valueVer4);
		
		ag.addEdge(v1, v2, weight);
		ag.addEdge(v3, v4, weight);
		
		assertTrue("The vertex were not added", ag.getNumberOfEdges() != 0);
		
	}

}

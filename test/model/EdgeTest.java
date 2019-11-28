package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EdgeTest {
	
	private Edge<Integer> edge;
	
	private void setUp1() {
		
	}

	private void setUp2() {
		
		Vertex<Integer> v1 = new Vertex<Integer>(5);
		Vertex<Integer> v2 = new Vertex<Integer>(4);
		double weight = 3;
		
		edge = new Edge<Integer>(v1, v2, weight);
		
	}
	
	@Test
	public void constructorTest() {
		setUp1();
		
		Vertex<Integer> v1 = new Vertex<Integer>(3);
		Vertex<Integer> v2 = new Vertex<Integer>(5);
		double weight = 1;
		
		edge = new Edge<Integer>(v1, v2, weight);
		
		assertTrue("The edge could not be correctly created", edge != null);
		assertTrue("The edge could not be correctly created", edge.getWeight() == weight);
		assertTrue("The edge could not be correctly created", edge.getSource() == v1);
		assertTrue("The edge could not be correctly created", edge.getDestination() == v2);
	}
	
	@Test 
	public void areTheSameTest() {
		setUp2();
		
		Vertex<Integer> v1 = new Vertex<Integer>(4);
		Vertex<Integer> v2 = new Vertex<Integer>(3);
		double weight = 2;

		Edge<Integer> edge2 = new Edge<Integer>(v1, v2, weight);
		
		boolean expected = false;
		
		assertTrue("The edges are the same", edge2.areTheSame(edge) == expected);
		
	}

}

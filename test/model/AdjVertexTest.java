package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AdjVertexTest {
	
	private AdjVertex<Integer> av;
	
	private void setUp1() {
		
	}
	
	private void setUp2() {
		int test = 4;
		av = new AdjVertex<Integer>(test);
	}

	@Test
	public void constructorTest() {
		setUp1();
		
		int first = 2;
		
		av = new AdjVertex<Integer>(first);
		
		assertTrue("The list of vertex could not be created", av.getAdjList() != null);
		
	}
	
	@Test
	public void isAdjacentTest() {
		setUp2();
		boolean expected = false;
		int test2 = 9;
		
		AdjVertex<Integer> v2 = new AdjVertex<Integer>(test2);
		
		assertTrue("The vertex are adjacent", av.isAdjacent(v2) == expected);
	}
	
	@Test
	public void findEdgeTest() {
		setUp2();
		int test3 = 8;
		
		AdjVertex<Integer> v2 = new AdjVertex<Integer>(test3);
		Edge<Integer> edge = new Edge<Integer>(av, v2, 6);
		
		assertTrue("The vertex can be found", av.findEdge(v2) != edge);
		
	}
	

}

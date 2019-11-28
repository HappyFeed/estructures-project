package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AdjListGraphTest {
	
	private AdjListGraph<Integer> listG;
	
	private void setUp1(){
		
	}
	
	@Test
	public void constructorTest() {
		setUp1();
		boolean directed = false;
		boolean weighted = false;
		
		listG = new AdjListGraph<Integer>(directed, weighted);
		
		assertTrue("the graph couldn't be created", listG != null);
		assertTrue("the graph couldn't be created", listG.getEdges() == null);
		assertTrue("the graph couldn't be created", listG.getVertices() == null);
		assertTrue("the graph couldn't be created", listG.getNumberOfEdges() == 0);

	}
}

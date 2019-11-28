package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VertexTest {
	
	private Vertex<Integer> v;
	
	private void setUp1() {
		
	}


	@Test
	public void constructorTest() {
		setUp1();
		int value = 3;
		v = new Vertex<Integer>(value);
		
		assertTrue("The vertex couldn't be created", v.getValue() == value);
		assertTrue("The vertex couldn't be created", v.getColor() == 0);
		assertTrue("The vertex couldn't be created", v.getPred() == null);
	}

}

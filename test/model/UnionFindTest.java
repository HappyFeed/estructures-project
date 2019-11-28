package model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UnionFindTest {

	private UnionFind uf;
	
	private void setUp1() {
		
	}
	
	private void setUp2() {
		uf = new UnionFind(2);
	}
	
	@Test
	public void constructorTest() {
		setUp1();
		int max = 5;
		
		uf = new UnionFind(max);
		assertTrue("Union find was correctly created", uf != null);
		int found = 2; 
		assertTrue("The matrix was not correctly created", uf.find(found) == found);
	}
	
	@Test
	public void findTest() {
		setUp2();
		int found1 = 1;
		int found2 = 2; 
		
		assertTrue("The matrix was not correctly created", uf.find(found1) == found1 || uf.find(found1) == found2);
	}

}

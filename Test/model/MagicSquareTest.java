package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MagicSquareTest {
	
	private Square s;
	
	public void setupScenary1() {
		s = new Square();
		s.setOrder(3);
		s.generate();
		s.fill(1, 1);
	}
	
	public void setupScenary2() {
		s = new Square();
		s.setOrder(3);
		s.generate();
		s.fill(1, 2);
	}
	
	public void setupScenary3() {
		s = new Square();
		s.setOrder(3);
		s.generate();
		s.fill(2, 3);
	}
	
	public void setupScenary4() {
		s = new Square();
		s.setOrder(3);
		s.generate();
		s.fill(2, 4);
	}
	
	public void setupScenary5() {
	int a= 4;
	s = new Square();
	s.setOrder(a);
	s.check();
	
	}

	@Test
	public void testCenterUpNO() {
		setupScenary1();
		
		int[][] generated = s.getSquare();
		int[][] manual = {{6,1,8},{7,5,3},{2,9,4}};
		for(int i=0; i<manual.length; i++) {
			for(int j=0; j<manual[i].length; j++) {
				assertTrue("Is correct.", generated[i][j] == manual[i][j]);
			}
		}
	}
	
	@Test
	public void testCenterUpNE() {
		setupScenary2();
		
		int[][] generated = s.getSquare();
		int[][] manual = {{8,1,6},{3,5,7},{4,9,2}};
		for(int i=0; i<manual.length; i++) {
			for(int j=0; j<manual[i].length; j++) {
				assertTrue("Is correct.", generated[i][j] == manual[i][j]);
			}
		}
	}
	
	@Test
	public void testCenterDownSO() {
		setupScenary3();
		
		int[][] generated = s.getSquare();
		int[][] manual = {{2,9,4},{7,5,3},{6,1,8}};
		for(int i=0; i<manual.length; i++) {
			for(int j=0; j<manual[i].length; j++) {
				assertTrue("Is correct.", generated[i][j] == manual[i][j]);
			}
		}
	}
	
	@Test
	public void testCenterDownSE() {
		setupScenary4();
		
		int[][] generated = s.getSquare();
		int[][] manual = {{4,9,2},{3,5,7},{8,1,6}};
		for(int i=0; i<manual.length; i++) {
			for(int j=0; j<manual[i].length; j++) {
				assertTrue("Is correct.", generated[i][j] == manual[i][j]);
			}
		}
	}
	

	@Test
	public void testNotNull() {
		
		setupScenary1();
		
		assertNotNull(s);
	}
	
	@Test
	public void testCheck() {
		setupScenary5();
		assertFalse(s.check());
		
	}

}
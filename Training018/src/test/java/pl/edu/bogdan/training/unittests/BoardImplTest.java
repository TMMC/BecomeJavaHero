package pl.edu.bogdan.training.unittests;

import static org.junit.Assert.*;
import org.junit.Test;

public class BoardImplTest {
	@Test
	public void boardCreationTest() {
		BoardImpl board = new BoardImpl();
	}
	
	@Test
	public void boardCreationWithDimensionTest() throws NegativeException {
		BoardImpl board = new BoardImpl(10, 10);
	}
	
	@Test (expected=NegativeException.class)
	public void boardCreationNegativeTest() throws NegativeException {
		BoardImpl board = new BoardImpl(-10, -10);
		
	}
	
	@Test (expected=NegativeException.class)
	public void boardCreationNegativeTest2() throws NegativeException {
		
		BoardImpl board2 = new BoardImpl(10, -10);
		
	}
	
	@Test (expected=NegativeException.class)
	public void boardCreationNegativeTest3() throws NegativeException {
	
		BoardImpl board3 = new BoardImpl(-10, 10);
	}
	
	@Test
	public void isWidthSetCorrectlyTest() throws NegativeException {
		BoardImpl board = new BoardImpl(10, 10);
		assertEquals("nie rowna sie", 10, board.getWidth(), 0.001) ;	
	}
	
	@Test
	public void isHeightSetCorrectlyTest() throws NegativeException {
		BoardImpl board = new BoardImpl(10, 10);
		assertEquals("nie rowna sie", 10, board.getHeight(), 0.001) ;	
	}
	
	@Test
	public void checkXOriginCoordinateTest() throws NegativeException {
		BoardImpl board = new BoardImpl(10, 10);
		assertEquals("nie rowna sie", 0, board.getXOriginCoordinate()) ;	
	}
	
	@Test
	public void checkYOriginCoordinateTest() throws NegativeException {
		BoardImpl board = new BoardImpl(10, 10);
		assertEquals("nie rowna sie", 0, board.getYOriginCoordinate()) ;	
	}
	
	@Test
	public void checkContainsPointTest() throws NegativeException {
		BoardImpl board = new BoardImpl(10, 10);
		assertTrue(board.containsPoint(1, 1));
	}
	
	@Test
	public void checkContainsPointLessZeroTest() throws NegativeException {
		BoardImpl board = new BoardImpl(10, 10);
		assertFalse(board.containsPoint(-1, 1));
	}
	
	@Test
	public void checkContainsPointGreater10Test() throws NegativeException {
		BoardImpl board = new BoardImpl(10, 10);
		assertFalse(board.containsPoint(11, 1));
	}
	
	@Test
	public void checkContainsPointLessZeroYTest() throws NegativeException {
		BoardImpl board = new BoardImpl(10, 10);
		assertFalse(board.containsPoint(5, -1));
	}
	
	@Test
	public void checkContainsPointGreater10YTest() throws NegativeException {
		BoardImpl board = new BoardImpl(10, 10);
		assertFalse(board.containsPoint(6, 12));
	}
	
	@Test
	public void checkContainsPointGreater10XYTest() throws NegativeException {
		BoardImpl board = new BoardImpl(10, 10);
		assertFalse(board.containsPoint(11, 11));
	}
	
	@Test
	public void interfaceImplementationTest() {
		Board board = new BoardImpl();
	}
}


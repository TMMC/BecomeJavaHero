package pl.edu.bogdan.training.unittests;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;


public class RobotTest {
	@Test
	public void simpleTest() throws RobotException {
		Board board = mock(Board.class);
		when(board.containsPoint(anyDouble(), anyDouble())).thenReturn(true);
		Robot robot = new Robot(board, 0, 0);
		
		robot.move(1, 1, 0);
		
		Assert.assertTrue(Double.compare(1.0, robot.getX()) == 0);
		Assert.assertTrue(Math.abs(0.0 - robot.getY()) < 0.000001);
		verify(board, times(1)).containsPoint(anyDouble(), anyDouble());
	}
	
	@Test
	public void robotDoesNotMoveTest() throws RobotException {
		Board board = mock(Board.class);
		when(board.containsPoint(anyDouble(), anyDouble())).thenReturn(true);
		Robot robot = new Robot(board, 0, 0);
		
		robot.move(0, 0, 0);
		
		Assert.assertTrue(Math.abs(0.0 - robot.getX()) < 0.000001);
		Assert.assertTrue(Math.abs(0.0 - robot.getY()) < 0.000001);
		verify(board, times(1)).containsPoint(anyDouble(), anyDouble());
	}
	
	@Test
	public void simpleCreationTest() throws RobotException {
		Board board = mock(Board.class);
		when(board.getXOriginCoordinate()).thenReturn(0);
		when(board.getYOriginCoordinate()).thenReturn(0);
		
		
		Robot robot = new Robot(board);
		
		
		Assert.assertTrue(Math.abs(0.0 - robot.getX()) < 0.000001);
		Assert.assertTrue(Math.abs(0.0 - robot.getY()) < 0.000001);
		verify(board, times(1)).getXOriginCoordinate();
		verify(board, times(1)).getYOriginCoordinate();
	}
	
	@Test(expected = RobotException.class)
	public void simpleRobotFailsTest() throws RobotException {
		Board board = mock(Board.class);
		when(board.containsPoint(anyDouble(), anyDouble())).thenReturn(false);
		Robot robot = new Robot(board, 0, 0);
		
		robot.move(1, 1, 0);
	}
	@Test
	public void setBoardTest() throws RobotException {
		Board board = mock(Board.class);
		
		when(board.containsPoint(anyDouble(), anyDouble())).thenReturn(true);
		
		Robot robot = new Robot(board, 1, 2);
		
		assertEquals(1.0, robot.getX(), 0.001);
		
		robot.setX(4);
		assertEquals(4.0, robot.getX(), 0.001);
	}
	
	class MockBoard implements Board {

		@Override
		public double getWidth() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getHeight() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getXOriginCoordinate() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getYOriginCoordinate() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean containsPoint(double x, double y) {
			if (x == 4 && y == 1) {
				return true;
			} else if (x == 4000 && y == 1) {
				return false;
			}
			return false;
		}
		
	}
	
	@Test(expected=RobotException.class)
	public void checkOnBoardTest() throws RobotException {
		Board board = mock(Board.class);
		
//		when(board.containsPoint(anyDouble(), anyDouble())).thenReturn(true);
		when(board.containsPoint(4.0, 1.0)).thenReturn(true);
		when(board.containsPoint(4000.0, 1.0)).thenReturn(false);
		
		Robot robot = new Robot(board, 1, 1);
		assertEquals(1.0, robot.getX(), 0.001);
		
		robot.setX(4);
		assertEquals(4.0, robot.getX(), 0.001);
		
		robot.setX(4000);
		fail();
	}
	
	@Test(expected=RobotException.class)
	public void checkOnBoardYTest() throws RobotException {
		Board board = mock(Board.class);
		
		when(board.containsPoint(anyDouble(), anyDouble())).thenReturn(true);
		when(board.containsPoint(1.0, 2000.0)).thenReturn(false);
		
		Robot robot = new Robot(board, 1, 1);
		robot.setY(2000);
		assertEquals(2000, robot.getY(), 0.001);
		
	}
}

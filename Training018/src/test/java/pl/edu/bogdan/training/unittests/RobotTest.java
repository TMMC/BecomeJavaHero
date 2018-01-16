package pl.edu.bogdan.training.unittests;

import org.junit.Assert;
import org.junit.Test;


import static org.mockito.Mockito.*;
public class RobotTest {
	@Test
	public void simpleTest() throws RobotException {
		Board board = mock(Board.class);
		when(board.containsPoint(anyDouble(), anyDouble())).thenReturn(true);
		Robot robot = new Robot(board, 0, 0);
		
		robot.move(1, 1, 0);
		
		Assert.assertTrue(Math.abs(1.0 - robot.getX()) < 0.000001);
		Assert.assertTrue(Math.abs(0.0 - robot.getY()) < 0.000001);
		verify(board, times(1)).containsPoint(anyDouble(), anyDouble());
	}
}

package com.capgemini.hanoi;

import org.junit.Test;

public class HanoiTest {
	
@Test(expected=IllegalStateException.class)
public void shouldNotMoveADiscFromAnEmptyTower() throws Exception{
	Game newGame = new Game(5);
	newGame.checkMovement(2,0);
}
@Test(expected=IllegalStateException.class)
public void shouldNotMoveBiggerDiscToSmaller() throws Exception{
	Game newGame = new Game(5);
	newGame.checkMovement(0,1);
	newGame.checkMovement(0,1);
}
@Test(expected=IllegalStateException.class)
public void shouldNotMoveADiscToNotExistingTower() throws Exception{
	Game newGame = new Game(5);
	newGame.checkMovement(0,3);
}
@Test(expected=IllegalStateException.class)
public void ShouldNotCreateAGameFor0Disc() throws Exception{
	Game newGame = new Game(0);
}
}

package controller;

import model.Enemy;
import model.Game;

public class SnakeGameController {
	
	private Game game;
	
	public SnakeGameController (Game game) {
		this.game = game;
	}
	
	public void initGame() {		
		initEnemies(10);
	}

	private void initEnemies(int numberOfEnemies) {	
		
		int xMax = this.game.getWidth();
		int yMax = this.game.getHeight();
		
		for (int i = 0; i < numberOfEnemies; i++) {			
			int posX = generatePositiveInt(xMax);
			int posY = generatePositiveInt(yMax);
			
			Enemy enemy = new Enemy(posX, posY);
			this.game.addEnemy(enemy);
		}		
	}

	private int generatePositiveInt(int max) {
		return (int) (Math.random() * max);
	}
}

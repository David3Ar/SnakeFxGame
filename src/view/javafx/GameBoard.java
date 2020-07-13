package view.javafx;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Enemy;
import model.Game;

public class GameBoard extends GridPane {

	int positionBaseSize = 25;

	private Game game;

	public GameBoard(Game game) {
		this.game = game;
		render();
	}

	public void render() {
		renderAllEnemys();
	}

	private void renderAllEnemys() {
		this.game.getEnemies().forEach(enemy -> {
			renderEnemy(enemy);
		});
	}

	private void renderEnemy(Enemy enemy) {
		ImageView iv = new ImageView(ImageLoader.ENEMY);
		this.add(iv, enemy.getX() * this.positionBaseSize, enemy.getY() * this.positionBaseSize);
	}

	public int getPositionBaseSize() {
		return this.positionBaseSize;
	}

	public void setPositionBaseSize(int positionBaseSize) {
		this.positionBaseSize = positionBaseSize;

	}

}

package view.javafx;

import controller.SnakeGameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Game;

public class GameView extends Application {
	Game game = new Game();
	SnakeGameController snakeGameController = new SnakeGameController(this.game);

	private int positionBaseSize = 25;

	private final int BORDER_SIZE = 3;
	private int titleHeight = 30;
	private int menuHeight = 30;

	private int rootWidth;
	private int rootHeight;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.recalculateRootSize();
		this.snakeGameController.initGame();

		BorderPane rootLayout = new BorderPane();
		GameBoard gameBoard = new GameBoard(this.game);
		gameBoard.setPositionBaseSize(this.positionBaseSize);
		rootLayout.setCenter(gameBoard);

		Scene scene = new Scene(rootLayout, this.rootWidth, this.rootHeight);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public void recalculateRootSize() {
		this.calcRootHeight();
		this.calcRootWidth();
	}

	private void calcRootHeight() {
		this.rootHeight = 0;
		this.rootHeight += (2 * this.BORDER_SIZE);
		this.rootHeight += this.titleHeight;
		this.rootHeight += this.menuHeight;
		this.rootHeight += (this.game.getHeight() * this.positionBaseSize);
	}

	private void calcRootWidth() {
		this.rootWidth = 0;
		this.rootWidth += (2 * this.BORDER_SIZE);
		this.rootWidth += (this.game.getWidth() * this.positionBaseSize);
	}

	public void startApp() {
		GameView.launch(new String[0]);
	}
}

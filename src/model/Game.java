package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class Game {
	
	private int width = 50;
    private int height = 30;
    
    private Timer timer;
    private int delay = 100;
    
    private int score= 0;
    private int moves= 0;
    
    private List<Enemy> enemies = new ArrayList<>();
    
    public void addEnemy(Enemy enemy) {
    	this.enemies.add(enemy);
    }

    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
}

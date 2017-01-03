package gui;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	private int score=0;
	private int lines=0;
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.drawString("Score: "+ score, Game.WIDTH-128, 32);
		g.drawString("Lines: "+ lines, Game.WIDTH-128, 48);
	}
	
	public void tick() {
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}
	
	
	
	
}

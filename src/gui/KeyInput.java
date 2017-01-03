package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import entity.Tetrimino;

public class KeyInput extends KeyAdapter {
	private Tetrimino chosen;

	public KeyInput(Tetrimino chosen) {
		this.chosen = chosen;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			chosen.moveLeft();
		} else if (key == KeyEvent.VK_RIGHT) {
			chosen.moveRight();
		} else if (key == KeyEvent.VK_DOWN) {
			chosen.setVel(Game.HEIGHT);
		} else if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			chosen.moveLeft();
		} else if (key == KeyEvent.VK_RIGHT) {
			chosen.moveRight();
		} else if (key == KeyEvent.VK_DOWN) {
			chosen.setVel(Game.HEIGHT);
		} else if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
}

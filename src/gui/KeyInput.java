package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			if (handler.getChosen().canMoveLeft()) {
				handler.getChosen().moveLeft();
			}
		} else if (key == KeyEvent.VK_RIGHT) {
			if (handler.getChosen().canMoveRight()) {
				handler.getChosen().moveRight();
			}
		} else if (key == KeyEvent.VK_DOWN) {
			while (handler.getChosen().canMoveDown()) {
				handler.getChosen().moveDown();
			}
		} else if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
}

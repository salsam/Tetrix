package gui;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7446192599263749847L;

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.requestFocus();
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
}

package entity;

import java.awt.Color;
import java.awt.Graphics;

import gui.Game;

public class Block extends GameObject {
	public static final int width = 16, height = 16;
	public boolean moving;

	public Block(int x, int y, Color color, int vel) {
		super(x, y, color, vel, width, height);
		this.moving = true;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void tick() {
		if (moving) {
			y += vel;
		}

		x = Game.clamp(x, 0, Game.WIDTH - width);
		y = Game.clamp(y, 0, Game.HEIGHT - height);

		if (this.y == Game.HEIGHT - height) {
			moving = false;
		}
	}

	public void moveLeft() {
		if (moving && x > 0) {
			x -= width;
		}
	}

	public void moveRight() {
		if (moving && x < Game.WIDTH - width) {
			x += width;
		}
	}
}

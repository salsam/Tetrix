package entity;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends GameObject {
	public static final int width = 16, height = 16;
	public boolean moving;

	public Block(int x, int y, Color color, int vel) {
		super(x, y, color, vel, width, height);
		this.moving=true;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void tick() {
		this.y += vel;
	}
}

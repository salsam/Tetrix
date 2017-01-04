package entity;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject {
	protected int x, y;
	protected boolean moving;
	protected Color color;

	public GameObject(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
		moving = false;
	}

	public abstract void moveDown();

	public abstract void moveLeft();

	public abstract void moveRight();

	public abstract void render(Graphics g);

	public abstract void tick();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

}

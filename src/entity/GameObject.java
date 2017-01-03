package entity;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject {
	protected int x, y;
	protected int width, height;
	protected Color color;
	protected int vel;

	public GameObject(int x, int y, Color color, int vel, int width, int height) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.vel = vel;
		this.width = width;
		this.height = height;
	}

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

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}
}

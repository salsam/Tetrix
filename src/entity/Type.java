package entity;

import java.awt.Color;

public enum Type {
	Cube(Color.yellow), L(Color.orange), I(Color.cyan), T(Color.magenta), Z(Color.green);

	private Color color;

	private Type(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}
}

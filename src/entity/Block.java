package entity;

import java.awt.Color;
import java.awt.Graphics;

import gui.Game;
import gui.Handler;

public class Block extends GameObject {
	public static final int width = 24, height = 24;
	private Handler handler;

	public Block(int x, int y, Color color, Handler handler) {
		super(x, y, color);
		moving = true;
		this.handler = handler;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.white);
		g.drawRect(x, y, width, height);
	}

	@Override
	public void tick() {
		if (moving) {
			y += height;
		}

		if (this.y == Game.HEIGHT - height) {
			moving = false;
		}
	}

	public boolean canMoveDown(Tetrimino t) {
		if (!moving || y >= Game.HEIGHT - height) {
			return false;
		}

		if (hasObjectBelow(t)) {
			return false;
		}

		return true;
	}

	public boolean canMoveLeft(Tetrimino t) {
		if (!moving || x <= Game.HUDWIDTH) {
			return false;
		}

		if (rightOfObject(t)) {
			return false;
		}

		return true;
	}

	public boolean canMoveRight(Tetrimino t) {
		if (!moving || x >= Game.WIDTH - Game.HUDWIDTH - width) {
			return false;
		}

		if (leftOfObject(t)) {
			return false;
		}

		return true;
	}

	private boolean isAbove(Block b) {
		return (b.getX() == x) && (b.getY() == y + height);
	}

	private boolean isRightOf(Block b) {
		return (b.getY() == y) && (b.getX() == x - width);
	}

	private boolean isLeftOf(Block b) {
		return (b.getY() == y) && (b.getX() == x + width);
	}

	private boolean isAboveTetrimino(Tetrimino tet) {
		for (Block b : tet.getBlocks()) {
			if (isAbove(b)) {
				return true;
			}
		}
		return false;
	}

	private boolean rightOfTetrimino(Tetrimino t) {
		for (Block b : t.getBlocks()) {
			if (isRightOf(b)) {
				return true;
			}
		}
		return false;
	}

	private boolean leftOfTetrimino(Tetrimino t) {
		for (Block b : t.getBlocks()) {
			if (isLeftOf(b)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasObjectBelow(Tetrimino whole) {
		for (GameObject obj : handler.getObjects()) {
			if (obj.getClass() == Block.class) {
				if (isAbove((Block) obj)) {
					return true;
				}
			} else if (obj.getClass() == Tetrimino.class) {
				Tetrimino tet = (Tetrimino) obj;

				if (tet.getID() != whole.getID() && isAboveTetrimino(tet)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean leftOfObject(Tetrimino whole) {
		for (GameObject obj : handler.getObjects()) {
			if (obj.getClass() == Block.class) {
				if (isLeftOf((Block) obj)) {
					return true;
				}
			} else if (obj.getClass() == Tetrimino.class) {
				Tetrimino tet = (Tetrimino) obj;

				if (tet.getID() != whole.getID() && leftOfTetrimino(tet)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean rightOfObject(Tetrimino whole) {
		for (GameObject obj : handler.getObjects()) {
			if (obj.getClass() == Block.class) {
				if (isRightOf((Block) obj)) {
					return true;
				}
			} else if (obj.getClass() == Tetrimino.class) {
				Tetrimino tet = (Tetrimino) obj;

				if (tet.getID() != whole.getID() && rightOfTetrimino(tet)) {
					return true;
				}
			}
		}
		return false;
	}

	public void moveDown() {
		y += height;
	}

	public void moveLeft() {
		x -= width;
	}

	public void moveRight() {
		x += width;
	}
}

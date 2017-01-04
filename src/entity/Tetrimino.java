package entity;

import java.awt.Graphics;

import gui.Handler;

public class Tetrimino extends GameObject {

	private int id;
	private Block[] blocks;
	private Type type;
	private Handler handler;

	public Tetrimino(int x, int y, Type type, Handler handler) {
		super(x, y, type.getColor());
		this.blocks = new Block[4];
		this.handler = handler;
		this.id = handler.getAvailableID();
		moving = true;
		this.type = type;
		buildBlocks();
	}

	public Block[] getBlocks() {
		return this.blocks;
	}

	public int getID() {
		return id;
	}

	@Override
	public void render(Graphics g) {
		for (int i = 0; i < blocks.length; i++) {
			blocks[i].render(g);
		}
	}

	@Override
	public void tick() {
		if (moving && canMoveDown()) {
			for (int i = 0; i < blocks.length; i++) {
				blocks[i].tick();

			}
		}
	}

	public boolean canMoveDown() {
		for (Block b : blocks) {
			if (!b.canMoveDown(this)) {
				moving = false;
				return false;
			}
		}

		return true;
	}

	public boolean canMoveLeft() {
		for (Block b : blocks) {
			if (!b.canMoveLeft(this)) {
				return false;
			}
		}

		return true;
	}

	public boolean canMoveRight() {
		for (Block b : blocks) {
			if (!b.canMoveRight(this)) {
				return false;
			}
		}

		return true;
	}

	public void moveDown() {
		for (Block b : blocks) {
			b.moveDown();
		}
	}

	public void moveLeft() {
		for (Block b : blocks) {
			b.moveLeft();
		}
	}

	public void moveRight() {
		for (int i = 0; i < blocks.length; i++) {
			blocks[i].moveRight();
		}
	}

	private void buildBlocks() {
		switch (type) {
		case Cube:
			createCube();
			break;
		case L:
			createL();
			break;
		case I:
			createI();
			break;
		case T:
			createT();
			break;
		case Z:
			createZ();
			break;
		default:
			break;
		}

	}

	private void createZ() {
		blocks[0] = new Block(x, y, color, handler);
		blocks[1] = new Block(x + Block.width, y, color, handler);
		blocks[2] = new Block(x + Block.width, y + Block.height, color, handler);
		blocks[3] = new Block(x + 2 * Block.width, y + Block.height, color, handler);
	}

	private void createT() {
		blocks[0] = new Block(x, y, color, handler);
		blocks[1] = new Block(x - Block.width, y + Block.height, color, handler);
		blocks[2] = new Block(x, y + Block.height, color, handler);
		blocks[3] = new Block(x + Block.width, y + Block.height, color, handler);
	}

	private void createI() {
		blocks[0] = new Block(x, y, color, handler);
		blocks[1] = new Block(x, y + Block.height, color, handler);
		blocks[2] = new Block(x, y + 2 * Block.height, color, handler);
		blocks[3] = new Block(x, y + 3 * Block.height, color, handler);
	}

	private void createL() {
		blocks[0] = new Block(x, y, color, handler);
		blocks[1] = new Block(x, y + Block.height, color, handler);
		blocks[2] = new Block(x, y + 2 * Block.height, color, handler);
		blocks[3] = new Block(x + Block.width, y + 2 * Block.height, color, handler);
	}

	private void createCube() {
		blocks[0] = new Block(x, y, color, handler);
		blocks[1] = new Block(x + Block.width, y, color, handler);
		blocks[2] = new Block(x, y + Block.height, color, handler);
		blocks[3] = new Block(x + Block.width, y + Block.height, color, handler);
	}

}

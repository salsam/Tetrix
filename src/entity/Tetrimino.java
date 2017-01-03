package entity;

import java.awt.Graphics;

import gui.Game;

public class Tetrimino extends GameObject {

	private Block[] blocks;
	private Type type;

	public Tetrimino(int x, int y, int vel, Type type) {
		super(x, y, type.getColor(), vel, y, vel);
		this.blocks = new Block[4];
		this.type = type;
		buildBlocks();
	}

	@Override
	public void render(Graphics g) {
		for (int i = 0; i < blocks.length; i++) {
			blocks[i].render(g);
		}
	}

	@Override
	public void tick() {
		for (int i = 0; i < blocks.length; i++) {
			blocks[i].tick();
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
		blocks[0] = new Block(x, y, color, vel);
		blocks[1] = new Block(x + Block.width, y, color, vel);
		blocks[2] = new Block(x + Block.width, y + Block.height, color, vel);
		blocks[3] = new Block(x + 2 * Block.width, y + Block.height, color, vel);
	}

	private void createT() {
		blocks[0] = new Block(x, y, color, vel);
		blocks[1] = new Block(x - Block.width, y + Block.height, color, vel);
		blocks[2] = new Block(x, y + Block.height, color, vel);
		blocks[3] = new Block(x + Block.width, y + Block.height, color, vel);
	}

	private void createI() {
		blocks[0] = new Block(x, y, color, vel);
		blocks[1] = new Block(x, y + Block.height, color, vel);
		blocks[2] = new Block(x, y + 2 * Block.height, color, vel);
		blocks[3] = new Block(x, y + 3 * Block.height, color, vel);
	}

	private void createL() {
		blocks[0] = new Block(x, y, color, vel);
		blocks[1] = new Block(x, y + Block.height, color, vel);
		blocks[2] = new Block(x, y + 2 * Block.height, color, vel);
		blocks[3] = new Block(x + Block.width, y + 2 * Block.height, color, vel);
	}

	private void createCube() {
		blocks[0] = new Block(x, y, color, vel);
		blocks[1] = new Block(x + Block.width, y, color, vel);
		blocks[2] = new Block(x, y + Block.height, color, vel);
		blocks[3] = new Block(x + Block.width, y + Block.height, color, vel);
	}
	
	public void moveLeft() {
		if (this.x>=Block.width) {
			for (int i=0;i<blocks.length;i++) {
				blocks[i].moveLeft();
			}
		}
	}
	
	public void moveRight() {
		if (this.x<=Game.WIDTH-Block.width) {
			for (int i=0;i<blocks.length;i++) {
				blocks[i].moveRight();
			}
		}
	}

}

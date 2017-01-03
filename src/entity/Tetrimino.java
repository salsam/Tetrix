package entity;

import java.awt.Color;
import java.awt.Graphics;

public class Tetrimino extends GameObject {

	private Block[] blocks;
	private Type type;

	public Tetrimino(int x, int y, Color color, int vel, Type type) {
		super(x, y, color, vel, y, vel);
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
			blocks[0]=new Block(x,y,color, vel);
			blocks[1]=new Block(x+Block.width,y,color, vel);
			blocks[2]=new Block(x,y+Block.height,color, vel);
			blocks[3]=new Block(x+Block.width,y+Block.height,color, vel);
			break;
		case L:
			blocks[0]=new Block(x,y,color, vel);
			blocks[1]=new Block(x,y+Block.height,color, vel);
			blocks[2]=new Block(x,y+2*Block.height,color, vel);
			blocks[3]=new Block(x+Block.width,y+2*Block.height,color, vel);
			break;
		case I:
			blocks[0]=new Block(x,y,color, vel);
			blocks[1]=new Block(x,y+Block.height,color, vel);
			blocks[2]=new Block(x,y+2*Block.height,color, vel);
			blocks[3]=new Block(x,y+3*Block.height,color, vel);
			break;
		case T:
			blocks[0]=new Block(x,y,color, vel);
			blocks[1]=new Block(x-Block.width,y+Block.height,color, vel);
			blocks[2]=new Block(x,y+Block.height,color, vel);
			blocks[3]=new Block(x+Block.width,y+Block.height,color, vel);
			break;
		case Z:
			blocks[0]=new Block(x,y,color, vel);
			blocks[1]=new Block(x+Block.width,y,color, vel);
			blocks[2]=new Block(x+Block.width,y+Block.height,color, vel);
			blocks[3]=new Block(x+2*Block.width,y+Block.height,color, vel);
			break;
		default:
			break;
		}

	}

}

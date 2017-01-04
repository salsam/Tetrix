package logic;

import java.util.Random;

import entity.Tetrimino;
import entity.Type;
import gui.Game;
import gui.Handler;

public class Spawn {
	private Handler handler;
	private Random r;

	public Spawn(Handler handler) {
		this.handler = handler;
		r = new Random();
	}

	public Tetrimino randomTetrimino() {
		Type type = Type.values()[r.nextInt(5)];
		return new Tetrimino(Game.WIDTH / 2, 0, type, handler);
	}

	public void spawn() {
		Tetrimino neu = randomTetrimino();
		handler.addObject(neu);
		handler.setChosen(neu);
	}
}

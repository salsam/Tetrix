package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import entity.Block;
import logic.Spawn;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 242446397740476223L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	public static final int HUDWIDTH = (WIDTH - 10 * Block.width) / 2;

	private boolean running = false;
	private Thread thread;

	private Handler handler;
	private HUD hud;
	private Spawn spawner;

	private Random r;

	public Game() {
		r = new Random();
		handler = new Handler();
		hud = new HUD();
		spawner = new Spawn(handler);

		spawner.spawn();

		this.addKeyListener(new KeyInput(handler));

		new Window(WIDTH, HEIGHT, "Tetris", this);
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 1.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.gray);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.black);
		g.fillRect(HUDWIDTH, 0, 10 * Block.width, HEIGHT);

		handler.render(g);
		hud.render(g);

		g.dispose();
		bs.show();
	}

	private void tick() {
		handler.tick();
		hud.tick();

		if (!handler.getChosen().isMoving()) {
			spawner.spawn();
		}
	}

	public static void main(String[] args) {
		new Game();
	}
}

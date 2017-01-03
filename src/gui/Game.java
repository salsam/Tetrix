package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import entity.Tetrimino;
import entity.Type;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 242446397740476223L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	private boolean running = false;
	private Thread thread;

	private Handler handler;
	private HUD hud;

	private Random r;

	public Game() {
		r = new Random();
		this.handler = new Handler();
		this.hud=new HUD();

		new Window(WIDTH, HEIGHT, "Tetris", this);

		Tetrimino chosen =randomTetrimino();
		handler.addObject(chosen);
		this.addKeyListener(new KeyInput(chosen));
		
	}

	public Tetrimino randomTetrimino() {
		Type type = Type.values()[r.nextInt(5)];
		return new Tetrimino(WIDTH/2, 0, 1, type);
	}

	public static int clamp(int var, int min, int max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		}
		return var;
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
		double amountOfTicks = 60.0;
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
				System.out.println("FPS: " + frames);
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

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);
		hud.render(g);

		g.dispose();
		bs.show();
	}

	private void tick() {
		handler.tick();
		hud.tick();
	}

	public static void main(String[] args) {
		new Game();
	}
}

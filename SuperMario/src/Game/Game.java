package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import EntityObject.Player;
import Enum.ObjectID;
import GameObject.Block;
import Handler.ObjectHandler;
import Input.KeyInput;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int width;
	public static int height;
	ObjectHandler objecthandler;

	private boolean running = false;

	Thread thread;

	public static void main(String[] args) {
		new Window(800, 600, "Super Mario", new Game());

	}

	public void init() {
		width = this.getWidth();
		height = this.getHeight();
		objecthandler = new ObjectHandler();
		objecthandler.addObject(new Block(200, 100, 50, 50, ObjectID.BLOCK));
		objecthandler.addObject(new Block(150, 50, 50, 50, ObjectID.BLOCK));
		objecthandler.addObject(new Block(250, 50, 50, 50, ObjectID.BLOCK));
		objecthandler.addObject(new Block(200, 0, 50, 50, ObjectID.BLOCK));
		objecthandler.addObject(new Player(200,50,50,50,ObjectID.PLAYER,objecthandler));

		this.addKeyListener(new KeyInput(objecthandler));
	}

	public synchronized void start() {
		running = true;
		thread = new Thread();
		thread.start();
		run();
	}

	@Override
	public void run() {
		init();
		this.requestFocus();

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}

	}

	public void tick() {
		objecthandler.tick();

	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);

		objecthandler.render(g);
		g.dispose();
		bs.show();

	}

}

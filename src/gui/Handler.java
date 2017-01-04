package gui;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import entity.GameObject;
import entity.Tetrimino;

public class Handler {
	private List<GameObject> objects;
	private int availableID;
	private Tetrimino chosen;

	public Handler() {
		objects = new LinkedList<GameObject>();
		availableID = 0;

	}

	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).render(g);
		}
	}

	public void tick() {
		Iterator<GameObject> iter = objects.iterator();
		while (iter.hasNext()) {
			iter.next().tick();
		}
	}

	public void addObject(GameObject object) {
		objects.add(object);
		availableID++;
	}

	public void removeObject(GameObject object) {
		objects.remove(object);
	}

	public List<GameObject> getObjects() {
		return objects;
	}

	public void setObjects(List<GameObject> objects) {
		this.objects = objects;
	}

	public int getAvailableID() {
		return availableID;
	}

	public void setAvailableID(int availableID) {
		this.availableID = availableID;
	}

	public Tetrimino getChosen() {
		return chosen;
	}

	public void setChosen(Tetrimino chosen) {
		this.chosen = chosen;
	}

}

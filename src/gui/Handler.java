package gui;

import java.awt.Graphics;
import java.util.LinkedList;

import entity.GameObject;

public class Handler {
	private LinkedList<GameObject> objects;
	
	public Handler() {
		this.objects= new LinkedList<GameObject>();
	}
	
	public void render(Graphics g) {
		for	(int i=0;i<objects.size();i++) {
			objects.get(i).render(g);
		}
	}
	
	public void tick() {
		for (int i=0;i<objects.size();i++) {
			objects.get(i).tick();
		}
	}
	
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}
} 

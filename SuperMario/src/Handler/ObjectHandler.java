package Handler;

import java.awt.Graphics;
import java.util.LinkedList;

import Mario.GameObject;

public class ObjectHandler {

	public LinkedList<GameObject> objectList = new LinkedList<GameObject>();

	private GameObject tempObject;

	public void render(Graphics g) {
		for (int i = 0; i < objectList.size(); i++) {
			tempObject = objectList.get(i);
			tempObject.render(g);
		}
	}

	public void tick() {
		for (int i = 0; i < objectList.size(); i++) {
			tempObject = objectList.get(i);
			tempObject.tick(objectList);
		}
	}

	public void addObject(GameObject obj) {
		this.objectList.add(obj);
	}

	public void removeObject(GameObject obj) {
		this.objectList.remove(obj);
	}
}

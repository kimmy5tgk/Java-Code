package GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Enum.ObjectID;
import Mario.GameObject;

public class Block extends GameObject {

	public Block(int x, int y, int width, int height, ObjectID id) {
		super(x, y, width, height, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		
	}

	@Override
	public void tick(LinkedList<GameObject> objectList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,width,height);
	}

}

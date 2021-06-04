package EntityObject;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Rectangle;
import java.util.LinkedList;

import Enum.ObjectID;
import Handler.ObjectHandler;
import Mario.GameObject;

public class Player extends GameObject{
	
	private float gravity = 0.1f;
	private final int maxSpeed = 10;
	ObjectHandler objecthandler;

	public Player(int x, int y, int width, int height, ObjectID id,ObjectHandler objecthandler) {
		super(x, y, width, height, id);
		this.objecthandler = objecthandler;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
//
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.yellow);
//		g2d.draw(getBounds());
//		g2d.draw(getBoundsTop());
//		g2d.draw(getBoundsRight());
//		g2d.draw(getBoundsLeft());
	}

	@Override
	public void tick(LinkedList<GameObject> objectList) {
		this.x+= this.velX;
		this.y+= this.velY;
		
		if(falling || jumping) {
			this.velY+= gravity;
			if(this.velY >= maxSpeed) {
				this.velX = maxSpeed;
			}
		}
		collision(objectList);
	}
	
	public void collision(LinkedList<GameObject> objectlist) {
		for (int i = 0; i < objecthandler.objectList.size(); i++) {
			GameObject tempObject = objecthandler.objectList.get(i);

			if (tempObject.getId() == ObjectID.BLOCK) {
				if (getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - tempObject.getHeight();
					velY = 0;
					falling = false;
					jumping = false;
				} else {
					falling = true;
				}
				if (getBoundsRight().intersects(tempObject.getBounds())) {

					x = tempObject.getX() - tempObject.getWidth();
					velX = 0;
				}
				if (getBoundsLeft().intersects(tempObject.getBounds())) {

					x = tempObject.getX() + tempObject.getWidth();
					velX = 0;
				}
				if (getBoundsTop().intersects(tempObject.getBounds())) {

					x = tempObject.getY() + tempObject.getHeight();
					velY = 0;
				}  
			}
		}
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)), (int) ((int) y + height / 2),
				(int) width / 2, (int) height / 2);
	}

	public Rectangle getBoundsTop() {

		return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)), (int) y, (int) width / 2,
				(int) height / 2);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int) x + width - 5), (int) y + 5, (int) 5, (int) height - 10);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);
	}

}

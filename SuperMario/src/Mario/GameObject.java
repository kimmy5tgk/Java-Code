package Mario;

import java.awt.Graphics;
import java.util.LinkedList;
import Enum.ObjectID;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected ObjectID id;
	
	protected float velX;
	protected float velY;

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	protected boolean falling = true;
	protected boolean jumping = true;

	public GameObject(int x, int y, int width, int height, ObjectID id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
    }
	
	public abstract void render(Graphics g);
	public abstract void tick(LinkedList<GameObject>objectList); 
	public abstract Rectangle getBounds();
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ObjectID getId() {
		return id;
	}

	public void setId(ObjectID id) {
		this.id = id;
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
}

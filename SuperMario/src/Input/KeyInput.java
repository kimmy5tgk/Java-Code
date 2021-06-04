package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Handler.ObjectHandler;
import Mario.GameObject;
import Enum.ObjectID;

public class KeyInput implements KeyListener {

	ObjectHandler objecthandler;
	public  KeyInput(ObjectHandler objecthandler) {
		this.objecthandler = objecthandler;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0;i<objecthandler.objectList.size();i++) {
			GameObject tempObject = objecthandler.objectList.get(i);
			if(tempObject.getId()== ObjectID.PLAYER) {
				
				if(key== KeyEvent.VK_LEFT) {
					tempObject.setVelX(-5);
				}
				if(key== KeyEvent.VK_RIGHT) {
					tempObject.setVelX(5);
				}
				if(key == KeyEvent.VK_SPACE && !tempObject.isJumping()) {
					 tempObject.setVelY(-5);
					 tempObject.setJumping(true);
				}
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0;i<objecthandler.objectList.size();i++) {
			GameObject tempObject = objecthandler.objectList.get(i);
			if(tempObject.getId()== ObjectID.PLAYER) {
				
				if(key== KeyEvent.VK_LEFT) {
					tempObject.setVelX(0);
				}
				if(key== KeyEvent.VK_RIGHT) {
					tempObject.setVelX(0);
				}
		    }
		}	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

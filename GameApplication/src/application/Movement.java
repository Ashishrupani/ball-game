package application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener{

	//Refers to the direction of the keys
	public boolean up , left, right, down; 
	
	@Override
	public void keyTyped(KeyEvent e) {
		//Won't be used for the purposes of this project
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//System.out.println("The key code is: " + keyCode);
		
		if(keyCode == 87 || keyCode == 38) { // UP
			//System.out.println("UP");
			up = true;
		}
		if(keyCode == 65 || keyCode == 37) { // Left
			//System.out.println("LEFT");
			left = true;
		} 
		if(keyCode == 68 || keyCode == 39) { //Right
			//System.out.println("RIGHT");
			right = true;
		}
		if(keyCode == 83 || keyCode == 40) { //Down
			//System.out.println("DOWN");
			down = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		
		if(keyCode == 87 || keyCode == 38) { // UP
			up = false;
		}
		if(keyCode == 65 || keyCode == 37) { // Left
			left = false;
		} 
		if(keyCode == 68 || keyCode == 39) { //Right
			right = false;
		}
		if(keyCode == 83 || keyCode == 40) { //Down
			down = false;
		}
		
	}

		
}

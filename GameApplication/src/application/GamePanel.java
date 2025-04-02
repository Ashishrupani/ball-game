package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;

import Entity.Entity;
import Entity.Player;

public class GamePanel extends JPanel implements Runnable{
	
	//Settings for the panel
	public int originalBlockSize = 16;  //refers to the size of the character 16x16
	public int scale = 3;               //to scale the character according to the screen size
	public int blockSize = originalBlockSize * scale;
	
	public int maxScreenSizeX = 16;  //max width of screen
	public int maxScreenSizeY = 12;  //max height of screen
	public int screenWidth = blockSize * maxScreenSizeX; // 768 pixels wide
	public int screenHeight = blockSize * maxScreenSizeY; // 576 pixels height
	
	
	Movement key = new Movement();
	Thread gameThread;
	Player player = new Player(this, key);
	
	public GamePanel(){
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(key);
		this.setFocusable(true);
		
		startGameThread();
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	
	//Main game loop
	@Override
	public void run() {
		
		double interval = 1000000000/60;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null)
		{
			//To maintain frames per second and limiting computer updates.
			currentTime = System.nanoTime();
			delta = delta + (currentTime - lastTime)/interval;
			lastTime = currentTime;
			
			//System.out.println("The game is running");
			if(delta >=1) {
				
			update();
			repaint();
			delta--;
			}
		}
		
	}
	

	public void update(){
		//update player based on the keys pressed
		player.updatePlayerMovement();
	}
	
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		
		Graphics2D gr2 = (Graphics2D)gr;
		player.drawPlayer(gr2);
		gr.dispose();
		
		
	}
	
	

}

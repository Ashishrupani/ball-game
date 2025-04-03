package Entity;

import java.awt.image.BufferedImage;

public class Entity {
	
	public int entityX, entityY, speed;   //Xcoordinate, Ycoordinate 
	public int velocityX, velocityY;  //Speed at which the sprite moves
	public BufferedImage up, right, left, down; //different images to simulate animation
	public String direction;
	public boolean jumpAvailable;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;  //ball facing up, left, right, down
	
}

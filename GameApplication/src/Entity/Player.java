package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import application.GamePanel;
import application.Movement;

public class Player extends Entity{
	
	GamePanel gp;  //game panel
	Movement key;  //movement handler
	
	public Player(GamePanel gp, Movement key)
	{
		this.gp = gp;
		this.key = key;
		setDefault();
		getImage();
	}
	
	public void setDefault() {
		entityX = 100;
		entityY = 100;
		velocityX = 4;
		velocityY = 4;
		speed = 4;
		direction = "up";
	}
	
	public void getImage() {
		
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/character/up.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/character/left.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/character/right.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/character/down.png"));
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void updatePlayerMovement()
	{
		if(key.up == true || key.down == true || key.left == true || key.right == true) {
		
		if(key.up == true)
		{
			direction = "up";
			if(velocityY == 0 && jumpAvailable == true)
			{
				velocityY = -gp.originalBlockSize;
				jumpAvailable = false;
			}
			
		}
//		if(key.down == true)
//		{
//			direction = "down";
//			entityY += velocityY;
//		}
		if(key.left == true)
		{
			direction = "left";
			entityX -= velocityX;
		}
		if(key.right == true)
		{
			direction = "right";
			entityX += velocityX;
		}
		
		//Help in animating the character.. changes between the different images.
		spriteCounter++;
		if(spriteCounter > 10)
		{
			if(spriteNum == 1) {    
				spriteNum = 2;
			}
			else if(spriteNum == 2) { 
				spriteNum = 3;
			}
			else if(spriteNum == 3) {
				spriteNum = 4;
			}
			else if(spriteNum == 4) {
				spriteNum = 1;
			}
			spriteCounter = 0;
			//System.out.println(spriteNum);
			
		}
		}
		
		//adding gravity to player
		if(velocityY < gp.gravity.gravity)
		{
			//entityY += velocityY;
			velocityY += 1;
		}
		if(velocityY + entityY < 385)
		{
			entityY += velocityY;
		}
		else
		{
			velocityY = 0;
			jumpAvailable = true;
		}
		
		
		//System.out.println(velocityY);
		
	}
	
	public void drawPlayer(Graphics2D gr2)
	{
//		gr2.setColor(Color.cyan);
//		gr2.fillRoundRect(entityX, entityY, gp.blockSize, gp.blockSize, gp.blockSize, gp.blockSize);
		
		BufferedImage image = null;
		
		switch(direction) {
			case "right":
				if(spriteNum == 1) {
					image = up;
				}
				else if(spriteNum == 2)
				{
					image = right;
				}
				else if(spriteNum == 3)
				{
					image = down;
				}
				else if(spriteNum == 4)
				{
					image = left;
				}
				break;
			
			case "left":
				if(spriteNum == 1) {
					image = up;
				}
				else if(spriteNum == 2)
				{
					image = left;
				
				}
				else if(spriteNum == 3)
				{
					image = down;
				
				}
				else if(spriteNum == 4)
				{
					image = right;
				}
			break;
			default:
				image = up;
				break;
		}
		
		//Draw the sprite on the screen
		gr2.drawImage(image, (int)entityX, (int)entityY, gp.blockSize, gp.blockSize, null);
		
	}
	
	
	
}

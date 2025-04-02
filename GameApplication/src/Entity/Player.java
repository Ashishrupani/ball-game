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
		entitySpeed = 4;
		direction = "down";
	}
	
	public void getImage() {
		
		try {
			test = ImageIO.read(getClass().getResourceAsStream("/images/up.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void updatePlayerMovement()
	{
		if(key.up == true)
		{
			entityY -= entitySpeed;
		}
		else if(key.down == true)
		{
			entityY += entitySpeed;
		}
		else if(key.left == true)
		{
			entityX -= entitySpeed;
		}
		else if(key.right == true)
		{
			entityX += entitySpeed;
		}
	}
	
	public void drawPlayer(Graphics2D gr2)
	{
//		gr2.setColor(Color.cyan);
//		gr2.fillRoundRect(entityX, entityY, gp.blockSize, gp.blockSize, gp.blockSize, gp.blockSize);
		
		BufferedImage image = test;
		gr2.drawImage(image, entityX, entityY, gp.blockSize, gp.blockSize, null);
		
	}
}

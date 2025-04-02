package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

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
	}
	
	public void setDefault() {
		entityX = 100;
		entityY = 100;
		entitySpeed = 4;
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
		gr2.setColor(Color.cyan);
		gr2.fillRoundRect(entityX, entityY, gp.blockSize, gp.blockSize, gp.blockSize, gp.blockSize);
	}
}

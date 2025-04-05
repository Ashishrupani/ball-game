package block;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import application.GamePanel;

public class BlockManager {

	GamePanel gp;
	Block[] block;
	int mapBlockNum[][];
	
	public BlockManager(GamePanel gp) {
		this.gp = gp;
		
		block = new Block[10];
		mapBlockNum = new int[gp.maxWorldX][gp.maxWorldY];
		getBlock();
		loadMap();
	}
	
	public void getBlock() {
		
		try {
			block[0] = new Block();
			block[0].image = ImageIO.read(getClass().getResourceAsStream("/environment/grass.png"));
			
			block[1] = new Block();
			block[1].image = ImageIO.read(getClass().getResourceAsStream("/environment/dirt.png"));
			
			block[2] = new Block();
			block[2].image = ImageIO.read(getClass().getResourceAsStream("/environment/brick.png"));
			
			block[3] = new Block();
			block[3].image = ImageIO.read(getClass().getResourceAsStream("/environment/sky.png"));
			
			block[4] = new Block();
			block[4].image = ImageIO.read(getClass().getResourceAsStream("/environment/cloud1.png"));
			
			block[5] = new Block();
			block[5].image = ImageIO.read(getClass().getResourceAsStream("/environment/cloud2.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void loadMap() {
		
		try {
			InputStream is = getClass().getResourceAsStream("/maps/worldMap.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldX && row < gp.maxWorldY) {
			String line = br.readLine();
				
			while(col < gp.maxWorldX) {
				String numbers[] = line.split(" ");
				int num = Integer.parseInt(numbers[col]);
				mapBlockNum[col][row] = num;
				//System.out.println("COL: "+ col + "   "+ "ROW: " + row + "   " + "NUM: " + num);
				col++;
			}
			if(col == gp.maxWorldX)
			{
				col = 0;
				row++;
			}
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void drawBlock(Graphics2D gr2) {
		
		//gr2.drawImage(block[0].image, 0, 0, gp.blockSize, gp.blockSize, null);
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldX && worldRow < gp.maxWorldY) {
			int blockNum = mapBlockNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.blockSize;
			int worldY = worldRow * gp.blockSize;
			int screenX = worldX - gp.player.entityX + gp.player.screenX;
			int screenY = worldY - gp.player.entityY + gp.player.screenY;
			
			
			
			if( worldX + gp.blockSize > gp.player.entityX - gp.player.screenX &&
				worldX - gp.blockSize < gp.player.entityX + gp.player.screenX &&
				worldY + gp.blockSize > gp.player.entityY - gp.player.screenY &&
				worldY - gp.blockSize < gp.player.entityY + gp.player.screenY) 
			
			{
			gr2.drawImage(block[blockNum].image, screenX, screenY,gp.blockSize, gp.blockSize, null);
			}
			worldCol++;
			
			if(worldCol == gp.maxWorldX) {
				worldCol = 0;
				worldRow++;
				
			}
		}
		
	}
}

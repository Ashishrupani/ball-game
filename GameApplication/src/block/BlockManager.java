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
		mapBlockNum = new int[gp.maxScreenSizeX][gp.maxScreenSizeY];
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
			InputStream is = getClass().getResourceAsStream("/maps/testmap.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxScreenSizeX && row < gp.maxScreenSizeY) {
			String line = br.readLine();
			
			while(col < gp.maxScreenSizeX) {
				String numbers[] = line.split(" ");
				int num = Integer.parseInt(numbers[col]);
				mapBlockNum[col][row] = num;
				col++;
			}
			if(col == gp.maxScreenSizeX)
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
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxScreenSizeX && row < gp.maxScreenSizeY) {
			int blockNum = mapBlockNum[col][row];
			gr2.drawImage(block[blockNum].image,x,y,gp.blockSize, gp.blockSize, null);
			col++;
			x += gp.blockSize;
			
			if(col == gp.maxScreenSizeX) {
				col = 0;
				x = 0;
				row++;
				y += gp.blockSize;
			}
		}
		
	}
}

package application;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		GamePanel panel = new GamePanel();
		JFrame window = new JFrame();
		
		//Window setup
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(panel.screenWidth, panel.screenHeight);
		window.setResizable(false);
		window.setTitle("Ball Game");
		//Adding GamePanel
		window.add(panel);
		window.pack();
		//Setting the window to the center of the screen
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
		
		

	}

}

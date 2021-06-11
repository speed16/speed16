package greedhead.state;

import greedhead.tilemap.Background;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.*;

public class MenuState extends GameState{
	
	private Background bg;
	
	private int curentChoice = 0;
	
	private String[] options = {"START","HELP","EXIT"};
	
	private Color titleColor;
	private Color homeColor;
	
	private Font titleFont;
	private Font font;
	private Font homeFont;
	public MenuState(GameManager gm) {
		this.gm = gm;
		try {
			
			bg = new Background("menubr.png", 1);
			bg.setVector(-0.1, 0);
			titleColor = new Color(34,139,34);
			titleFont = new Font("Woodcut", Font.ITALIC, 50);
			font = new Font("Woodcut", Font.ITALIC, 50);
			homeColor = new Color(125, 30, 20);
			homeFont = new Font("Arial", Font.BOLD, 20);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {}

	@Override
	public void update() {
		bg.update();
		
	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Greed Head", 150, 140);
		
		g.setColor(homeColor);
		g.setFont(homeFont);
		g.drawString("принадлежит company home MainGames", 280, 540);
		
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == curentChoice) {
				g.setColor(Color.BLUE);
			}
			else {
				g.setColor(Color.GREEN);
			}
			g.drawString(options[i], 250, 250 + i * 100);
		}
	}
	
	private void select(){
		if(curentChoice == 0){
			//start
		}
if(curentChoice == 1){
			//help
		}
if(curentChoice == 2){
	System.exit(0);
}
	}

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP){
			curentChoice--;
		}
		if(k == KeyEvent.VK_DOWN){
			curentChoice++;
			if(curentChoice == options.length)
				curentChoice = 0;
			
		}
	}

	@Override
	public void keyReleased(int k) {
	}

}

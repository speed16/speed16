package greedhead.state;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameManager {
	private ArrayList<GameState> gamestates;
	
	private int curentState;
	
	public static final int MENUSTATE = 0;
	public static final int LEVEL_1_STATE = 1;
	
	public GameManager(){
		gamestates = new ArrayList<GameState>();
		curentState = MENUSTATE;
		gamestates.add(new MenuState(this));
	}
	
	public void setState(int state){
		curentState = state;
		
		gamestates.get(curentState).init();
	}
	
	public void update(){
		gamestates.get(curentState).update();
	}
	
	public void draw(Graphics2D g){
		gamestates.get(curentState).draw(g);
	}
	
	public void keyPressed(int k){
		gamestates.get(curentState).keyPressed(k);
	}
	
	public void keyReleased(int k){
		gamestates.get(curentState).keyReleased(k);
	}

}

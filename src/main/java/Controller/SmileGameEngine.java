/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Game;
import java.awt.image.BufferedImage;

/**
 *
 * @author ravin
 */
public class SmileGameEngine {
    String thePlayer = null;
    int counter = 0;
    int score = 0;
    GameServer theGames = new GameServer();
    Game current = null;
    
    public SmileGameEngine(String player) {
		thePlayer = player;
    }
    
    public BufferedImage nextGame() {
		current = theGames.getRandomGame();
		return current.getImage();

    }
    
    public boolean checkSolution( int i) {
		if (i == current.getSolution()) {
			score = score +50;
			return true;
		} else {
			return false;
		}
    }
    public int getScore() {
		return score;
    }
}

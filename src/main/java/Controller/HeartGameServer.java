/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.HeartGame;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/**
 *
 * @author ravin
 */
public class HeartGameServer {
    /**
	 * Retrieves a game for any positive number less than 1000.
	 * 
	 * @param i
	 * @return a random game.
	 * @throws MalformedURLException
	 */
	public HeartGame getRandomGame() throws MalformedURLException {
		int i =  new Random().nextInt(1000); 
		String urlLocation = "https://sanfoh.com/heartgame/sixeqgame_" + i + ".png";
		URL url = new URL(urlLocation);
		int solution  = i % 10; 
                System.out.println("Solution :"+solution);
		return new HeartGame(url, solution);
	}
}

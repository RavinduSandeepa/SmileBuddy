/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.image.BufferedImage;

/**
 * Smile Game Model class
 * @author ravin
 */
public class Game {
    BufferedImage image = null; 	
    int solution = -1;
    
    public Game(BufferedImage image, int solution) {
		super();
		this.image = image;
		this.solution = solution;
	}

    public BufferedImage getImage() {
        return image;
    }

    public int getSolution() {
        return solution;
    }
    
    
}

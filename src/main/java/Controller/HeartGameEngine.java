/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.HeartGame;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author ravin
 */
public class HeartGameEngine {

    String thePlayer = null;

    /**
     * Each player has their own game engine.
     *
     * @param player
     */
    public HeartGameEngine(String player) {
        thePlayer = player;
    }

    int counter = 0;
    int score = 0;
    HeartGameServer theGames = new HeartGameServer();
    HeartGame current = null;

    /*
 * Retrieves a game. This basic version only has two games that alternate.
     */
    public URL nextGame() {
        try {
            current = theGames.getRandomGame();
            return current.getLocation();

        } catch (MalformedURLException e) {
            System.out.println("Something went wrong when trying to retrieve game " + counter + "!");
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Checks if the parameter i is a solution to the game URL. If so, score is
     * increased by one.
     *
     * @param game
     * @param i
     * @return
     */
    public boolean checkSolution(URL game, int i) {
        if (i == current.getSolution()) {
            score = score+50;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retrieves the score.
     *
     * @param player
     * @return
     */
    public int getScore() {
        return score;
    }
}

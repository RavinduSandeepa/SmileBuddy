/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Game;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import javax.imageio.ImageIO;

/**
 *
 * @author ravin
 */
public class GameServer {

    //mothod od reading URL
    private static String readUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            InputStream inputStream = url.openStream();

            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString("UTF-8");
        } catch (Exception e) {
            /* To do: proper exception handling when URL cannot be read. */
            System.out.println("An Error occured: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    //method of getting random game by calling readURL method
    public Game getRandomGame() {
       
        String smileapi = "https://marcconrad.com/uob/smile/api.php?out=csv&base64=yes";
        String dataraw = readUrl(smileapi);
        String[] data = dataraw.split(",");

        //decoding the image to byte array
        byte[] decodeImg = Base64.getDecoder().decode(data[0]);
        ByteArrayInputStream quest = new ByteArrayInputStream(decodeImg);

        //getting the solution from the String data array
        int solution = Integer.parseInt(data[1]);
        System.out.println("Solution :"+solution);

        BufferedImage img = null;
        try {
            img = ImageIO.read(quest);
            return new Game(img, solution);
        } catch (IOException e1) {
            // TODO Add proper exception handling. 
            e1.printStackTrace();
            return null;
        }
    }
}

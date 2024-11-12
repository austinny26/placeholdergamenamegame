package entities;

import main.GamePanel;
import main.KeyInputs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends Entity{

    private final String BIG_IMAGE_FRAMES = "sprites/knight";
    private ArrayList<BufferedImage> playerFrames;
    private int currentFrame;

    GamePanel gp;
    KeyInputs keyH;

    public Player(GamePanel gp, KeyInputs keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "right";
    }

    public void getPlayerImage(){
        try {

            still1 = ImageIO.read(getClass().getResourceAsStream("/player/character-1.png.png"));
            still2 = ImageIO.read(getClass().getResourceAsStream("/player/character2-1.png.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/characterwalk-1.png.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/characterwalk2-1.png.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/characterwalk3-1.png.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/characterwalk4-1.png.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/characterwalk5-1.png.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/player/characterwalk6-1.png.png"));
            idle1 = ImageIO.read(getClass().getResourceAsStream("/player/characteridleing-1.png.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/characteridleing2-1.png.png"));


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        if (keyH.upPressed) {
            direction = "up";
            y -= speed;
        }
        if (keyH.downPressed) {
            direction = "down";
            y += speed;
        }
        if (keyH.leftPressed) {
            direction = "left";
            x -= speed;
        }
        if (keyH.rightPressed) {
            direction = "right";
            x += speed;
        }

        spriteCounter++;
        if(spriteCounter > 10) {
            for (int i = 0; i < 7; i++) {
                spriteNum++;
                if (spriteNum >= 6){
                    spriteNum = 0;
                }
                if (i == 6){
                    i = 0;
                }
            }
            spriteCounter = 0;
        }

    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch(direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "right":
                for (int i = 1; i < 5; i++) {
                    String file = BIG_IMAGE_FRAMES + "_" + i + ".png";
                    loadFrames(file);

                break;
            case "left":
                image = left1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}

package entities;

import main.GamePanel;
import main.KeyInputs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;


public class Player extends Entity {
    private int spriteNum = 0;
    private int spriteNumIdle = 0;// Current frame in the animation
    private int spriteCounter = 0; // Counter for animation speed
    public boolean isIdle = true; // Tracks whether the player is moving or idle

    GamePanel gp;
    KeyInputs keyH;

    public Player(GamePanel gp, KeyInputs keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "right";
    }


    public void update() {
        boolean moving = false; // Tracks if any movement key is pressed

        if (keyH.upPressed) {
            direction = "up";
            y -= speed;
            moving = true;
        } else if (keyH.downPressed) {
            direction = "down";
            y += speed;
            moving = true;
        } else if (keyH.leftPressed) {
            direction = "left";
            x -= speed;
            moving = true;
        } else if (keyH.rightPressed) {
            direction = "right";
            x += speed;
            moving = true;
        }

    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        if (isIdle) {
            // Use idle frames when the player is not moving
            image = draw(Rectangle2D)

        } else {
            // Select the correct moving sprite based on direction
            switch (direction) {
                case "up":
                    image = upSprites[spriteNum];
                    break;
                case "down":
                    image = draw(Rectangle2D());
                    break;
                case "right":
                    image = rightSprites[spriteNum];
                    break;
                case "left":
                    image = leftSprites[spriteNum];
                    break;
            }
        }

        if (image != null) {
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        }
    }
    public String toString() {
       return "Player at " +
    }
}
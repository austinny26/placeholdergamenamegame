package entities;

import main.GamePanel;
import main.KeyInputs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;


public class Player extends Entity {
    private BufferedImage[] rightSprites = new BufferedImage[6];
    private BufferedImage[] leftSprites = new BufferedImage[6];
    private BufferedImage[] upSprites = new BufferedImage[6];
    private BufferedImage[] downSprites = new BufferedImage[6];
    private BufferedImage[] idleSprites = new BufferedImage[2]; // Array for idle animation

    private int spriteNum = 0;
    private int spriteNumIdle = 0;// Current frame in the animation
    private int spriteCounter = 0; // Counter for animation speed
    private boolean isIdle = true; // Tracks whether the player is moving or idle

    GamePanel gp;
    KeyInputs keyH;

    public Player(GamePanel gp, KeyInputs keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        loadRightSprites();
        loadLeftSprites();
        loadUpSprites();
        loadDownSprites();
        loadIdleSprites(); // Load idle frames
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "right";
    }

    // Helper method to load right-direction frames
    private void loadRightSprites() {
        for (int i = 1; i <= 6; i++) {
            String filePath = Paths.get("res/player/characterwalk" + i + "-1.png.png").toString();
            try {
                rightSprites[i - 1] = ImageIO.read(new File(filePath));
            } catch (IOException e) {
                System.out.println("Error loading right sprite at path: " + filePath);
                e.printStackTrace();
            }
        }
    }

    // Helper method to load left-direction frames
    private void loadLeftSprites() {
        for (int i = 1; i <= 6; i++) {
            String filePath = Paths.get("res/player/characterleft" + i + ".png").toString();
            try {
                leftSprites[i - 1] = ImageIO.read(new File(filePath));
            } catch (IOException e) {
                System.out.println("Error loading left sprite at path: " + filePath);
                e.printStackTrace();
            }
        }
    }

    // Helper method to load up-direction frames
    private void loadUpSprites() {
        for (int i = 1; i <= 6; i++) {
            String filePath = Paths.get("res/player/characterup" + i + ".png").toString();
            try {
                upSprites[i - 1] = ImageIO.read(new File(filePath));
            } catch (IOException e) {
                System.out.println("Error loading up sprite at path: " + filePath);
                e.printStackTrace();
            }
        }
    }

    // Helper method to load down-direction frames
    private void loadDownSprites() {
        for (int i = 1; i <= 6; i++) {
            String filePath = Paths.get("res/player/characterdown" + i + ".png").toString();
            try {
                downSprites[i - 1] = ImageIO.read(new File(filePath));
            } catch (IOException e) {
                System.out.println("Error loading down sprite at path: " + filePath);
                e.printStackTrace();
            }
        }
    }

    // Helper method to load idle frames
    private void loadIdleSprites() {
        for (int i = 1; i <= 2; i++) {
            String filePath = Paths.get("res/player/idle" + i + ".png").toString();
            try {
                idleSprites[i - 1] = ImageIO.read(new File(filePath));
            } catch (IOException e) {
                System.out.println("Error loading idle sprite at path: " + filePath);
                e.printStackTrace();
            }
        }
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

        isIdle = !moving; // Set to idle if no keys are pressed

        // Update the frame number for animation
        spriteCounter++;
        if (spriteCounter > 10 && !isIdle) { // Adjust delay for animation speed
            spriteNum = (spriteNum + 1) % 6;// Cycle through frames 0 to 5
            spriteCounter = 0;
        }
        else if (spriteCounter > 30) {
            spriteNumIdle = (spriteNumIdle + 1) % 2;// Cycle through frames 0 to 1
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        if (isIdle) {
            // Use idle frames when the player is not moving
            image = idleSprites[spriteNumIdle];

        } else {
            // Select the correct moving sprite based on direction
            switch (direction) {
                case "up":
                    image = upSprites[spriteNum];
                    break;
                case "down":
                    image = downSprites[spriteNum];
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
}
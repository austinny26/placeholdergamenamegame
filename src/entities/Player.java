package entities;

import main.GamePanel;
import main.KeyInputs;

import java.awt.*;

public class Player extends Entity{

    GamePanel gp;
    KeyInputs keyH;

    public Player(GamePanel gp, KeyInputs keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();

    }
    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;

    }
    public void update(){

        if (keyH.upPressed) {
            y -= speed;
        }
        if (keyH.downPressed) {
            y += speed;
        }
        if (keyH.leftPressed) {
            x -= speed;
        }
        if (keyH.rightPressed) {
            x += speed;
        }

    }
    public void draw(Graphics2D g2){

        g2.setColor (Color.white);

        g2.fillRect (x, y, gp.tileSize, gp.tileSize);
    }
}

package entities;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

public class Entity {

    public int x, y;
    public int speed;

    public BufferedImage idle1, idle2, still1, still2, up1, up2, down1, down2;
    public BufferedImage right1, right2, right3, right4, right5, right6, left1;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;


}

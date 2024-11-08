package main;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile (standard game sprite sizes)
    final int scale = 3; // to scale the character size with screen

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int MaxScreenRow = 14;
    final int screenWidth = tileSize * MaxScreenRow;
    final int screenHeight = tileSize * maxScreenCol;

    Thread gameThread;


    public GamePanel() {

        this.setPreferredSize(new Dimension (screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

    }
}

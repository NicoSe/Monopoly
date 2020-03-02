package MISC;

import CONTROL.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BackgroundPanel extends JPanel {

    private BufferedImage image;

    public BackgroundPanel() {

        try {
            image = ImageIO.read(getClass().getResource("/Sprites/MonopolyBoard.PNG"));
        } catch (IOException ex) {
            System.out.println("a");
        }
        setBounds(0,0,1920,1080);

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, Main.getJFrame().getWidth()/2-200, 7, null);
    }
}

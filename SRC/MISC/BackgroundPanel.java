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
        setAlignmentX(CENTER_ALIGNMENT);
        setAlignmentY(CENTER_ALIGNMENT);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, Main.getJFrame().getWidth()/2-345, 0, null);
    }
}

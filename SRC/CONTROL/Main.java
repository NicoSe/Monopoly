package CONTROL;

import GUI.HomeUI;
import LOGIC.Options;
import LOGIC.Player;
import MISC.BackgroundPanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static JFrame jf;
    private static BackgroundPanel background;

    public static void main(String[] args) {
        new Options();
        jf = new JFrame("Monopoly");

        jf.setSize(1100,800);
        jf.setExtendedState(Frame.MAXIMIZED_BOTH);
        jf.setUndecorated(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setBackground(new Color(61,130,219));

        background = new BackgroundPanel();
        background.add(new HomeUI().init());

        jf.add(background);
        jf.setVisible(true);
    }

    public static JFrame getJFrame(){
        return jf;
    }
    public static JPanel getBackgroundPanel(){return background;}

    public static void ExecuteGame() {
        JLayeredPane layeredPane = jf.getLayeredPane();
        Player p1 = new Player("Gustav", Color.RED);
        layeredPane.add(p1.drawPLayer(200,200,30,30),0);
    }
}

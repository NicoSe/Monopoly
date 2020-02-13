package CONTROL;

import GUI.HomeUI;
import LOGIC.Options;
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

        background = new BackgroundPanel();
        background.add(new HomeUI().init());
        jf.add(background);
        jf.setBackground(new Color(61,130,219));
        jf.setVisible(true);
    }

    public static JFrame getJFrame(){
        return jf;
    }
    public static JPanel getBackgroundPanel(){return background;}
}

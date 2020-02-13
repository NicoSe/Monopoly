package CONTROL;

import GUI.HomeUI;
import LOGIC.Options;
import MISC.BackgroundPanel;

import javax.swing.*;
import javax.swing.text.LayeredHighlighter;
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
        jf.setVisible(true);

        background = new BackgroundPanel();
        background.setBounds(0,0,1920,1080);
        //background.add(new HomeUI().init());

        JLayeredPane l = jf.getLayeredPane();

        l.setLayout(null);

        l.add(background,JLayeredPane.FRAME_CONTENT_LAYER);
        //l.add(new HomeUI().init(), JLayeredPane.DEFAULT_LAYER);


    }

    public static JFrame getJFrame(){
        return jf;
    }
    public static JPanel getBackgroundPanel(){return background;}
}

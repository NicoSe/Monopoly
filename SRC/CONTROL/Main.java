package CONTROL;

import CITY.City;
import GUI.HomeUI;
import LOGIC.Options;
import LOGIC.Player;
import MISC.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    private static JFrame jf;
    private static BackgroundPanel background;
    public static ArrayList<Player> PLAYER = new ArrayList<Player>();
    public static Player turn;

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

    // do all preperations for the game
    public static void ExecuteGame() {
        JLayeredPane layeredPane = jf.getLayeredPane();
        for (Player p:PLAYER) {
            City.field[0].addPlayers(p);
        }
    }
}

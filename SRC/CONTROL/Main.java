package CONTROL;

import CITY.City;
import GUI.GameUI;
import GUI.HomeMenueUI;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame jf = new JFrame("Monopoly");

        jf.setSize(1100,800);
        //jf.setExtendedState(Frame.MAXIMIZED_BOTH);
        jf.setUndecorated(false);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        new City();
        jf.setContentPane(new HomeMenueUI().init());

    }
}

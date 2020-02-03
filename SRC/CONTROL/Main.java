package CONTROL;

import GUI.GameUI;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame jf = new JFrame("Monopoly");

        jf.setSize(1100,800);
        jf.setExtendedState(Frame.MAXIMIZED_BOTH);
        jf.setUndecorated(true);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.setContentPane(new GameUI().init());

    }
}

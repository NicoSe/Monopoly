package GUI;

import CITY.City;
import CONTROL.Main;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeUI {
    private JPanel MainPanel;
    private JButton NEWGAMEButton;
    private JButton LOADGAMEButton;
    private JButton OPTIONSButton;
    private JButton EXITButton;

    public HomeUI() {
        NEWGAMEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new City();
                Main.getBackgroundPanel().removeAll();
                Main.getBackgroundPanel().add(new GameOptionsUI().init());
                Main.getJFrame().revalidate();
                Main.getJFrame().repaint();
            }
        });
        LOADGAMEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Main.getJFrame().setContentPane(new GameUI().init());
            }
        });
        OPTIONSButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Main.getJFrame().setContentPane(new GameUI().init());
            }
        });
        EXITButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel init() {
        MainPanel.setOpaque(false);
        return MainPanel;
    }
}

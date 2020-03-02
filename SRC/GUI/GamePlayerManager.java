package GUI;

import CITY.City;
import CONTROL.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePlayerManager {
    private JPanel MainPanel;
    private JButton startGameButton;
    private JButton BACKButton;
    private JLabel P1label;
    private JLabel P2label;
    private JLabel P3label;
    private JLabel P4label;
    private JLabel P5label;
    private JLabel P6Label;
    private JTextField P1text;
    private JComboBox P1color;
    private JTextField P2text;
    private JComboBox P2color;
    private JTextField P3text;
    private JComboBox P3color;
    private JTextField P4text;
    private JComboBox P4color;
    private JTextField P5text;
    private JComboBox P5color;
    private JTextField P6text;
    private JComboBox P6color;

    private String[] colorArray = new String[10];

    public GamePlayerManager(int players, int ai){
        colorArray[0] = "RED";
        colorArray[1] = "BLUE";
        colorArray[2] = "YELLOW";
        colorArray[3] = "GREEN";
        colorArray[4] = "WHITE";
        colorArray[5] = "BLACK";
        colorArray[6] = "CYAN";
        colorArray[7] = "ORANGE";
        colorArray[8] = "MAGENTA";
        colorArray[9] = "PINK";

        for(int i=0; i<10; i++){
            P1color.addItem(colorArray[i]);
        }
        for(int i=0; i<10; i++){
            P2color.addItem(colorArray[i]);
        }
        for(int i=0; i<10; i++){
            P3color.addItem(colorArray[i]);
        }
        for(int i=0; i<10; i++){
            P4color.addItem(colorArray[i]);
        }
        for(int i=0; i<10; i++){
            P5color.addItem(colorArray[i]);
        }
        for(int i=0; i<10; i++){
            P6color.addItem(colorArray[i]);
        }

        startGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new City();
                Main.getJFrame().remove(Main.getBackgroundPanel());
                JLayeredPane layeredPane = Main.getJFrame().getLayeredPane();
                layeredPane.setLayout(null);
                layeredPane.setSize(1920,1080);
                layeredPane.add(new GameUI().init(),-300);
                Main.getJFrame().revalidate();
                Main.getJFrame().repaint();
                Main.ExecuteGame();
            }
        });
        BACKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Main.getBackgroundPanel().removeAll();
                Main.getBackgroundPanel().add((new GameOptionsUI().init()));
                Main.getJFrame().revalidate();
                Main.getJFrame().repaint();
            }
        });
    }

    public JPanel init(){
        return MainPanel;
    }
}

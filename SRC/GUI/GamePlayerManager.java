package GUI;

import CITY.City;
import CONTROL.Main;
import LOGIC.AI;
import LOGIC.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class GamePlayerManager {
    private JPanel MainPanel;
    private JButton startGameButton;
    private JButton BACKButton;
    private JLabel P1label;
    private JLabel P2label;
    private JLabel P3label;
    private JLabel P4label;
    private JLabel P5label;
    private JLabel P6label;
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
    private JLabel DebugLabel;

    private String[] colorArray = new String[10];
    private int playerAmount;
    private int aiAmount;

    // initialize base variables for this class
    public GamePlayerManager(int players, int ai){
        playerAmount = players;
        aiAmount = ai;
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
    }

    //return the mainPanel and handle all click commands and data usage
    public JPanel init(){
        // set Comboboxes
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

        P1color.setSelectedIndex(0);
        P2color.setSelectedIndex(1);
        P3color.setSelectedIndex(2);
        P4color.setSelectedIndex(3);
        P5color.setSelectedIndex(4);
        P6color.setSelectedIndex(5);

        // set labels based on the amount of players and ai's
        if (playerAmount>= 1){
            P1label.setText("PLAYER 1");
            if (aiAmount >= 1) P2label.setText("AI 1");
            if (aiAmount >= 2) P3label.setText("AI 2");
            if (aiAmount >= 3) P4label.setText("AI 3");
            if (aiAmount >= 4) P5label.setText("AI 4");
            if (aiAmount == 5) P6label.setText("AI 5");
        }
        if (playerAmount >= 2){
            P2label.setText("PLAYER 2");
            if (aiAmount >= 1) P3label.setText("AI 1");
            if (aiAmount >= 2) P4label.setText("AI 2");
            if (aiAmount >= 3) P5label.setText("AI 3");
            if (aiAmount == 4) P6label.setText("AI 4");
        }
        if (playerAmount >= 3){
            P3label.setText("PLAYER 3");
            if (aiAmount >= 1) P4label.setText("AI 1");
            if (aiAmount >= 2) P5label.setText("AI 2");
            if (aiAmount == 3) P6label.setText("AI 3");
        }
        if (playerAmount >= 4){
            P4label.setText("PLAYER 4");
            if (aiAmount >= 1) P5label.setText("AI 1");
            if (aiAmount == 2) P6label.setText("AI 2");
        }
        if (playerAmount >= 5){
            P5label.setText("PLAYER 5");
            if (aiAmount == 1) P6label.setText("AI 1");
        }
        if (playerAmount == 6){
            P6label.setText("PLAYER 6");
        }

        // Disabele all unused player or ai widgets
        if (playerAmount + aiAmount == 2){
            P3color.setVisible(false);
            P3label.setVisible(false);
            P3text.setVisible(false);

            P4color.setVisible(false);
            P4label.setVisible(false);
            P4text.setVisible(false);

            P5color.setVisible(false);
            P5label.setVisible(false);
            P5text.setVisible(false);

            P6color.setVisible(false);
            P6label.setVisible(false);
            P6text.setVisible(false);
        }
        else if (playerAmount + aiAmount == 3){
            P4color.setVisible(false);
            P4label.setVisible(false);
            P4text.setVisible(false);

            P5color.setVisible(false);
            P5label.setVisible(false);
            P5text.setVisible(false);

            P6color.setVisible(false);
            P6label.setVisible(false);
            P6text.setVisible(false);
        }
        else if (playerAmount + aiAmount == 4){
            P5color.setVisible(false);
            P5label.setVisible(false);
            P5text.setVisible(false);

            P6color.setVisible(false);
            P6label.setVisible(false);
            P6text.setVisible(false);
        }
        else if (playerAmount + aiAmount == 5){
            P6color.setVisible(false);
            P6label.setVisible(false);
            P6text.setVisible(false);
        }

        // initialize buttons
        startGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DebugLabel.setText("");
                if (createPlayers()){
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
            }
        });
        BACKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DebugLabel.setText("");
                Main.getBackgroundPanel().removeAll();
                Main.getBackgroundPanel().add((new GameOptionsUI().init()));
                Main.getJFrame().revalidate();
                Main.getJFrame().repaint();
            }
        });
        return MainPanel;
    }

    // create all players based on the given settings and ai opponents
    private boolean createPlayers(){
        if(validatePlayerSettings()){
            ArrayList<Color> colors = createColorArray();

            // Player 1
            Main.PLAYER.add(new Player(P1text.getText(), colors.get(0)));
            // Player or AI
            if (P2label.getText().contains("PLAYER")){
                Main.PLAYER.add(new Player(P2text.getText(), colors.get(1)));
            }
            else if (P2label.getText().contains("AI")){
                Main.PLAYER.add(new AI(P2text.getText(), colors.get(1)));
            }
            // Player or AI 3
            if (P3label.getText().contains("PLAYER")){
                Main.PLAYER.add(new Player(P3text.getText(), colors.get(2)));
            }
            else if (P3label.getText().contains("AI")){
                Main.PLAYER.add(new AI(P3text.getText(), colors.get(2)));
            }
            // Player or AI 4
            if (P4label.getText().contains("PLAYER")){
                Main.PLAYER.add(new Player(P4text.getText(), colors.get(3)));
            }
            else if (P4label.getText().contains("AI")){
                Main.PLAYER.add(new AI(P4text.getText(), colors.get(3)));
            }
            // Player or AI 5
            if (P5label.getText().contains("PLAYER")){
                Main.PLAYER.add(new Player(P5text.getText(), colors.get(4)));
            }
            else if (P5label.getText().contains("AI")){
                Main.PLAYER.add(new AI(P5text.getText(), colors.get(4)));
            }
            // Player or AI 6
            if (P6label.getText().contains("PLAYER")){
                Main.PLAYER.add(new Player(P6text.getText(), colors.get(5)));
            }
            else if (P6label.getText().contains("AI")){
                Main.PLAYER.add(new AI(P6text.getText(), colors.get(5)));
            }
            return true;
        }
        else{
            DebugLabel.setText("All players must have different colors and names!");
            return false;
        }
    }

    // create an ArrayList of colors of all players
    private ArrayList<Color> createColorArray(){
        ArrayList<Color> out = new ArrayList<>();
        out.add(detectColor((String) Objects.requireNonNull(P1color.getSelectedItem())));
        out.add(detectColor((String) Objects.requireNonNull(P2color.getSelectedItem())));
        out.add(detectColor((String) Objects.requireNonNull(P3color.getSelectedItem())));
        out.add(detectColor((String) Objects.requireNonNull(P4color.getSelectedItem())));
        out.add(detectColor((String) Objects.requireNonNull(P5color.getSelectedItem())));
        out.add(detectColor((String) Objects.requireNonNull(P6color.getSelectedItem())));
        return out;
    }

    // get a string and return the right color
    private Color detectColor(String c){
        switch (c){
            case "RED": return Color.RED;
            case "BLUE": return Color.BLUE;
            case "YELLOW": return Color.YELLOW;
            case "GREEN": return Color.GREEN;
            case "WHITE": return Color.WHITE;
            case "BLACK": return Color.BLACK;
            case "CYAN": return Color.CYAN;
            case "ORANGE": return Color.ORANGE;
            case "MAGENTA": return Color.MAGENTA;
            case "PINK": return Color.PINK;
            default: return null;
        }
    }

    // prove if all given information and settings are correct, such as no double colors ar names
    private boolean validatePlayerSettings(){
        if(playerAmount > 0) return true; //TODO: entfernen
        HashSet<Integer> hash = new HashSet<>();

        // check if alle colors different
        if (hash.add(P1color.getSelectedIndex()) && hash.add(P2color.getSelectedIndex()) && hash.add(P3color.getSelectedIndex())
        && hash.add(P4color.getSelectedIndex()) && hash.add(P5color.getSelectedIndex()) && hash.add(P6color.getSelectedIndex())){

            // check if all names different
            hash.clear();
            HashSet<String> hash2 = new HashSet<>();
            if (hash2.add(P1text.getText()) && hash2.add(P2text.getText()) && hash2.add(P3text.getText())
            && hash2.add(P4text.getText()) && hash2.add(P5text.getText()) && hash2.add(P6text.getText())){

                // check if all names are not empty
                hash2.clear();
                if (P1text.getText() != "" && P2text.getText() != "" && P3text.getText() != "" && P4text.getText() != ""
                && P5text.getText() != "" && P6text.getText() != ""){

                    return true;
                }
            }
        }
        return false;
    }
}

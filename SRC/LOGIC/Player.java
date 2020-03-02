package LOGIC;

import CITY.City;
import CITY.Streets;
import CONTROL.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player{

    private double money;
    public ArrayList<Streets> ownStreets;
    private boolean inPrision = false;
    public int position;
    private String name;
    private Color color;
    private JPanel icon;


    public Player(String Name, Color c) {
        name = Name;
        money = 1000;
        position = 0;
        color = c;
    }

    public String getName(){return name;}

    public double getMoney(){
        return money;
    }

    public void changeMoney(double value, boolean inc){
        if (inc) money = money + value;
        else {
            if (money-value <0){
                //TODO hypothek ausführen
            }
            else money = money - value;
        }
    }

    public void goToPrison(){
        inPrision = true;
        position = 10;
    }

    public void setPosition(int pos){
        City.field[position].deletePlayer(this);
        position = pos;
        City.field[position].addPlayers(this);
    }

    public void comeFree(){
        inPrision = false;
    }

    public boolean getIsPrisoned(){return inPrision;}

    public boolean allStreets(Color color, int streetCounter) {
        int counter = 0;
        for(int i=0; i<ownStreets.size(); i++){
            if(ownStreets.get(i).getColor() == color) counter++;
        }
        if (counter == streetCounter) return true;
        return false;
    }

    public JPanel drawPLayer(int x, int y, int width, int height){
        Main.getJFrame().getLayeredPane().remove(icon);
        icon = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                g.setColor(color);
                super.paintComponent(g);
                g.fillOval(0, 0, width, height);
            }
        };
        icon.setBounds(x,y,width,height);
        icon.setOpaque(false);
        return icon;
    }
}

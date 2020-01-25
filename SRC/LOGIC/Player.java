package LOGIC;

import java.awt.*;
import java.util.ArrayList;

public class Player {

    private double money;

    public ArrayList<STREET> ownStreets;

    private boolean inPrision = false;

    private int position;


    public void Player(){
        money = 1000;
        position = 0;
    }

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

    public void comeFree(){
        inPrision = false;
    }

    public boolean allStreets(Color color, int streetCounter) {
        int counter = 0;
        for(int i=0; i<ownStreets.size(); i++){
            if(ownStreets.get(i).getColor() == color) counter++;
        }
        if (counter == streetCounter) return true;
        return false;
    }
}

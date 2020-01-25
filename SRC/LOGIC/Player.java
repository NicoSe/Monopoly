package LOGIC;

import java.util.ArrayList;

public class Player {

    private double money;

    public ArrayList<Field> ownStreets;

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
        else money = money - value;
    }

    public void goToPrison(){
        inPrision = true;
        position = 10;
    }

    public void comeFree(){
        inPrision = false;
    }
}

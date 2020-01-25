package LOGIC;

import java.util.Random;

public class Dice {

    private int equals_counter = 0;

    public int throwDice(){
        int firstDice = new Random().nextInt(6) + 1;
        int secoundDice = new Random().nextInt(6) + 1;

        if (firstDice == secoundDice) equals_counter++;

        //if (equals_counter >= 3) Player.gotoprision

        System.out.println("(" + firstDice + "," + secoundDice + ")");
        return firstDice + secoundDice;
    }
}

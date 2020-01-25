package LOGIC;

import java.util.Random;

public class Dice {

    public int[] throwDice(){
        int firstDice = new Random().nextInt(6) + 1;
        int secoundDice = new Random().nextInt(6) + 1;

        System.out.println("(" + firstDice + "," + secoundDice + ")");
        int[] out = new int[2];
        out[0] = firstDice;
        out[1] = secoundDice;
        return out;
    }
}

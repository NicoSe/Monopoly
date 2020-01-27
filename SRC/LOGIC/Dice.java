package LOGIC;

import java.util.Random;

public class Dice {

    public static int[] dices = new int[2];

    public static void throwDice(){
        int firstDice = new Random().nextInt(6) + 1;
        int secoundDice = new Random().nextInt(6) + 1;

        dices[0] = firstDice;
        dices[1] = secoundDice;
    }
}

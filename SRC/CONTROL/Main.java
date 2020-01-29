package CONTROL;

import GUI.MainFrame;
import LOGIC.*;

import java.util.Scanner;


public class Main{

    public static void main(String[] args){


        MainFrame mf = new MainFrame();

        City city = new City();
        Player p1 = new Player("Nico");
/*
        Dice die = new Dice();
        int[] dices = new int[2];
        int equalsCounter = 0;

        while(true) {
            dices = die.throwDice();
            if (dices[0] == dices[1]) equalsCounter++;

            if(equalsCounter == 3){
                p1.goToPrison();
            }

            if(!p1.getIsPrisoned()) {
                p1.position += (dices[0] + dices[1]);
                if (p1.position >= 39) {
                    p1.position = p1.position % 39- 1;
                    p1.changeMoney(2000, true);
                }
            }
            else{
                dices = die.throwDice();
                if (dices[0] == dices[1]) p1.comeFree();
            }
            Field f = city.getField(p1.position);
            //f.action(p1);

            System.out.println("Money: " + p1.getMoney());
            System.out.println("Pos: " + p1.position);
            System.out.println(f.getName());

            Scanner in = new Scanner(System.in);
            String s = in. nextLine();
        }*/
    }
}
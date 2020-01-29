package CONTROL;

import GUI.MainFrame;
import CITY.*;
import LOGIC.Dice;
import LOGIC.Player;

import java.util.Scanner;


public class Main{

    public static void main(String[] args){


        MainFrame mf = new MainFrame();

        City city = new City();
        Player p1 = new Player("Nico");

        Dice die = new Dice();
        int equalsCounter = 0;

        Field f = city.getField(p1.position);
        System.out.println("Money: " + p1.getMoney());
        System.out.println("Pos: " + p1.position);
        System.out.println(f.getName());

        while(true) {
            Scanner in = new Scanner(System.in);
            String line = in. nextLine();

            die.throwDice();
            if (Dice.dices[0] == Dice.dices[1]) equalsCounter++;

            if(equalsCounter == 3){
                p1.goToPrison();
            }

            if(!p1.getIsPrisoned()) {
                p1.position += (Dice.dices[0] + Dice.dices[1]);
                if (p1.position >= 39) {
                    p1.position = p1.position % City.field.length;
                    p1.changeMoney(200, true);
                }
            }
            else{
                int pash = 0;
                System.out.println(">>imprisoned<<");
                while(pash<3){
                    die.throwDice();
                    System.out.println("Throw: " + (Dice.dices[0]+Dice.dices[1]));
                    if (Dice.dices[0] == Dice.dices[1]) p1.comeFree();
                    pash++;
                }
            }
            f = city.getField(p1.position);
            f.action(p1);

            System.out.println("Money: " + p1.getMoney());
            System.out.println("Throw: " + (Dice.dices[0]+Dice.dices[1]));
            System.out.println(f.getName());
            if(f instanceof STREET) {
                Streets s = null;
                s = (Streets) f;
                System.out.println(s.getPrize());
            }
        }
    }
}
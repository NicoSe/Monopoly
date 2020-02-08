package CITY;

import LOGIC.Dice;
import LOGIC.Player;

import java.awt.*;

public class INDUSTRY_Field extends Field implements Streets {

    private Player owner;
    private Color color;
    private int hypothek;
    private int streetCounter;
    private boolean isHypothek = false;


    public INDUSTRY_Field(String Name, int Prize, int StreetCounter, int Hypothek, Color Color){
        name = Name;
        owner = null;
        prize = Prize;
        streetCounter = StreetCounter;
        hypothek = Hypothek;
        color = Color;
    }
    @Override
    public void changeOwner(Player newPlayer){
        owner = newPlayer;
        newPlayer.ownStreets.add(this);
    }

    @Override
    public Player getOwner(){return owner;}

    @Override
    public void changeHypothekStatus(){
        isHypothek = !isHypothek;
    }

    @Override
    public boolean isHypothek(){
        return isHypothek;
    }

    @Override
    public int getHypothek(){
        return hypothek;
    }


    @Override
    public Color getColor(){
        return color;
    }

    @Override
    public boolean buyStreet(Player player){
        if(owner == null && player.getMoney() >= prize){
            player.changeMoney(prize, false);
            owner = player;
            player.ownStreets.add(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean payTax(Player player){
        if(owner != null){
            double payAmount = 0;
            int counter = 0;
            for(int i=0; i<owner.ownStreets.size(); i++){
                if(owner.ownStreets.get(i).getColor() == color) counter++;
            }
            switch (counter){
                case 1: payAmount = (Dice.dices[0] + Dice.dices[1]) * 4;break;
                case 2: payAmount = (Dice.dices[0] + Dice.dices[1]) * 10;break;
            }

            if(player.getMoney() >= payAmount){
                player.changeMoney(payAmount,false);
                owner.changeMoney(payAmount, true);
                return true;
            }
        }
        return false;
    }

    @Override
    public void action(Player player) {
        System.out.println(">>Hi");
        //TODO Player get Option: buyStreet, pay, ignore
    }

}

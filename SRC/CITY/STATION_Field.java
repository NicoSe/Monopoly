package CITY;

import LOGIC.Player;

import java.awt.*;

public class STATION_Field extends Field implements Streets{

    private Player owner;
    private Color color;
    private int hypothek;
    private int streetCounter;
    private boolean isHypothek = false;
    private int house1fee;
    private int house2fee;
    private int house3fee;
    private int house4fee;

    public STATION_Field(String Name, int Prize, int StreetCounter, int Hypothek, Color Color,
                        int House1fee, int House2fee, int House3fee, int House4fee){
        name = Name;
        owner = null;
        prize = Prize;
        streetCounter = StreetCounter;
        hypothek = Hypothek;
        color = Color;
        house1fee = House1fee;
        house2fee = House2fee;
        house3fee = House3fee;
        house4fee = House4fee;
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
            int payAmount = 0;
            int counter = 0;
            for(int i=0; i<owner.ownStreets.size(); i++){
                if(owner.ownStreets.get(i).getColor() == color) counter++;
            }
            switch (counter){
                case 1: payAmount = house1fee;break;
                case 2: payAmount = house2fee;break;
                case 3: payAmount = house3fee;break;
                case 4: payAmount = house4fee;break;
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

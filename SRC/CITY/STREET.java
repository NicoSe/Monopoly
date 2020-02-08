package CITY;

import LOGIC.Player;

import java.awt.*;

public class STREET extends Field implements Streets{
    
    private Player owner;
    private Color color;
    private int hypothek;
    private int streetCounter;
    private boolean isHypothek = false;
    private int housePrize;
    private int houses;
    private int hotels;
    private int fee;
    private int house1fee;
    private int house2fee;
    private int house3fee;
    private int house4fee;
    private int hotelfee;

    public STREET(String Name, int Prize, int StreetCounter, int Hypothek, Color Color, int HousePrize,
                      int Fee, int House1fee, int House2fee, int House3fee, int House4fee, int Hotelfee){
        name = Name;
        owner = null;
        prize = Prize;
        streetCounter = StreetCounter;
        hypothek = Hypothek;
        color = Color;
        housePrize = HousePrize;
        fee = Fee;
        house1fee = House1fee;
        house2fee = House2fee;
        house3fee = House3fee;
        house4fee = House4fee;
        hotelfee = Hotelfee;
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
            switch (houses){
                case 0: {
                    if(owner.allStreets(color, streetCounter)) payAmount += fee * 2;
                    else payAmount += fee;
                    break;
                }
                case 1: payAmount += house1fee;
                case 2: payAmount += house2fee;
                case 3: payAmount += house3fee;
                case 4: payAmount += house4fee;
            }
            if(hotels == 1) payAmount += hotelfee;

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

    public boolean buildHouse(Player player){
        if (player.allStreets(color, streetCounter)) {
            if (hotels >= 1 || houses >= 4) return false;
            if (player.getMoney() >= housePrize) {
                player.changeMoney(housePrize, false);
                houses++;
                return true;
            }
        }
        return false;
    }

    public boolean buildHotel(Player player){
        if (houses != 4 || hotels != 0) return false;
        else if (houses == 4 && hotels == 0){
            if(player.getMoney() >= housePrize){
                player.changeMoney(housePrize, false);
                houses = 0;
                hotels = 1;
                return true;
            }
        }
        return false;
    }
}

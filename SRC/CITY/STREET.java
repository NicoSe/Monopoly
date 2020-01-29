package CITY;

import LOGIC.Player;

import java.awt.*;

public class STREET extends Field implements Streets{

    private String name;
    private Player owner;
    private Color color;
    private double prize;
    private double hypothek;
    private int streetCounter;
    private boolean isHypothek = false;
    private double housePrize;
    private int houses;
    private int hotels;
    private double fee;
    private double house1fee;
    private double house2fee;
    private double house3fee;
    private double house4fee;
    private double hotelfee;

    public STREET(String Name, double Prize, int StreetCounter, double Hypothek, Color Color, double HousePrize,
                      double Fee, double House1fee, double House2fee, double House3fee, double House4fee, double Hotelfee){
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
    public double getHypothek(){
        return hypothek;
    }

    @Override
    public double getPrize(){
        return prize;
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
    public String getName() {
        return name;
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

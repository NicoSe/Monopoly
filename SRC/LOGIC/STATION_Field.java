package LOGIC;

import java.awt.*;

public class STATION_Field extends Field implements Streets{

    private String name;
    private Player owner;
    private Color color;
    private double prize;
    private double hypothek;
    private int streetCounter;
    private boolean isHypothek = false;
    private double house1fee;
    private double house2fee;
    private double house3fee;
    private double house4fee;

    public STATION_Field(String Name, double Prize, int StreetCounter, double Hypothek, Color Color,
                        double House1fee, double House2fee, double House3fee, double House4fee){
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
    public String getName() {
        return name;
    }

    @Override
    public void action(Player player) {
        //TODO Player get Option: buyStreet, pay, ignore
    }
}

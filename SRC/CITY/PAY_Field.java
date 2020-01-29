package CITY;

import LOGIC.Player;

public class PAY_Field extends Field {

    private double payAmount;
    private String name;

    public PAY_Field(String Name, double PayAmount){
        name = Name;
        payAmount = PayAmount;
    }

    @Override
    public void action(Player player) {
        player.changeMoney(payAmount, false);
    }

    public String getName(){
        return name;
    }

    public double getPayAmount(){
        return payAmount;
    }
}

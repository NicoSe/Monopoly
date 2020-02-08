package CITY;

import LOGIC.Player;

public class PAY_Field extends Field {

    private int payAmount;

    public PAY_Field(String Name, int PayAmount){
        name = Name;
        payAmount = PayAmount;
        prize = PayAmount;
    }

    @Override
    public void action(Player player) {
        player.changeMoney(payAmount, false);
    }

    public String getPayAmount(){
        return Integer.toString(payAmount);
    }
}

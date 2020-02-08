package CITY;

import LOGIC.Player;

public class GoToP_Field extends Field {


    public GoToP_Field(){
        name = "Go To Prison!";
    }

    @Override
    public void action(Player player) {
        player.goToPrison();
    }
}

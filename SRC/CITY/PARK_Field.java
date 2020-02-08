package CITY;

import LOGIC.Player;

public class PARK_Field extends Field {

    public PARK_Field(){
        name = "Free Parking";
    }

    @Override
    public void action(Player player) {
        return;
    }
}

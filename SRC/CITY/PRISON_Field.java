package CITY;

import LOGIC.Player;

public class PRISON_Field extends Field {

    public PRISON_Field(){
        name = "Prison";
    }

    @Override
    public void action(Player player) {
        System.out.println(">>Visit");
    }
}

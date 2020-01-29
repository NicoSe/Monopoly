package CITY;

import LOGIC.Player;

public class EVENT_Field extends Field {

    private String name;
    private Card[] cards; //TODO: event cards

    public EVENT_Field(){
        name = "Change";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void action(Player player) {

    }

    private void drawCard(Player player){

    }
}

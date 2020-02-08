package CITY;

import LOGIC.Player;

public class EVENT_Field extends Field {

    private Card[] cards; //TODO: event cards

    public EVENT_Field(){
        name = "Change";
    }

    @Override
    public void action(Player player) {
    }

    private void drawCard(Player player){

    }
}

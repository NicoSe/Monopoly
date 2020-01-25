package LOGIC;

public class COMMUNITY_Field extends Field {

    private String name;
    private Card[] cards; //TODO community cards

    public COMMUNITY_Field(){
        name = "Community Treasure";
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

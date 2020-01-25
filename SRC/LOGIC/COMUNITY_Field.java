package LOGIC;

public class COMUNITY_Field implements Field {

    private String name;
    private Card[] cards;

    public void COMMUNITY_Field(){
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

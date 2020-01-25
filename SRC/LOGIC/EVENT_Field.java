package LOGIC;

public class EVENT_Field implements Field {

    private String name;
    private Card[] cards;

    public void EVENT_Field(){
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

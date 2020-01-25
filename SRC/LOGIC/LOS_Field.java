package LOGIC;

public class LOS_Field extends Field {

    private String name;

    public LOS_Field(){
        name = "LOS";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void action(Player player) {
        player.changeMoney(2000, true);
    }
}

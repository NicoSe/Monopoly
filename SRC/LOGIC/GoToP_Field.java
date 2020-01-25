package LOGIC;

public class GoToP_Field extends Field {

    private String name;

    public GoToP_Field(){
        name = "Go To Prison!";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void action(Player player) {
        player.goToPrison();
    }
}

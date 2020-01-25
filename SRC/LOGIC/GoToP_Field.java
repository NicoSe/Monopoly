package LOGIC;

public class GoToP_Field implements Field {

    private String name;

    public void GoToP_Field(){
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

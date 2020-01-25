package LOGIC;

public class PARK_Field extends Field {

    private String name;

    public PARK_Field(){
        name = "Free Parking";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void action(Player player) {
        return;
    }
}

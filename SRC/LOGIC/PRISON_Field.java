package LOGIC;

public class PRISON_Field extends Field {

    private String name;

    public PRISON_Field(){
        name = "Prison";
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

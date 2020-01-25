package LOGIC;

public class PRISON_Field implements Field {

    private String name;

    public void PRISON_Field(){
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

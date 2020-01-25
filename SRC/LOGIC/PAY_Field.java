package LOGIC;

public class PAY_Field implements Field {

    private double payAmount;
    private String name;

    public void PAY_Field(String Name, double PayAmount){
        name = Name;
        payAmount = PayAmount;
    }

    @Override
    public void action(Player player) {
        player.changeMoney(payAmount, false);
    }

    public String getName(){
        return name;
    }

    public double getPayAmount(){
        return payAmount;
    }
}

package LOGIC;

public class STREET implements Field {

    private String name;
    private Player owner;
    private double prize;
    private double hypothek;
    private boolean isHypothek = false;

    public void Field(String Name, double Prize, double Hypothek){
        name = Name;
        owner = null;
        prize = Prize;
        hypothek = Hypothek;
    }

    public void changeOwner(Player newPlayer){
        owner = newPlayer;
        newPlayer.ownStreets.add(this);
    }

    public void changeHypothekStatus(){
        isHypothek = !isHypothek;
    }

    public boolean isHypothek(){
        return isHypothek;
    }

    public double getHypothek(){
        return hypothek;
    }

    public double getPrize(){
        return prize;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void action(Player player) {

    }
}

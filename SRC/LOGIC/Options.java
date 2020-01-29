package LOGIC;

public class Options {

    private static float volume;
    private static String moneySpezifier;
    private static int playerAmount;

    public Options(){
        volume = 100;
        moneySpezifier = "M";
        playerAmount = 2;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float Volume) {
        volume = Volume;
    }

    public String getMoneySize() {
        return moneySpezifier;
    }

    public void setMoneySize(String MoneySpezifier) {
        moneySpezifier = MoneySpezifier;
    }

    public int getPlayerAmount() {
        return playerAmount;
    }

    public void setPlayerAmount(int PlayerAmount) {
        playerAmount = PlayerAmount;
    }
}

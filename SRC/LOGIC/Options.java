package LOGIC;

public class Options {

    public static float volume;
    public static String moneySpecifier;
    public static int playerAmount;
    public static boolean mode3D = false;

    public Options(){
        volume = 100;
        moneySpecifier = "M";
        playerAmount = 2;
    }

    public void setVolume(float Volume) {
        volume = Volume;
    }

    public void setMoneySize(String MoneySpezifier) {
        moneySpecifier = MoneySpezifier;
    }

    public void setPlayerAmount(int PlayerAmount) {
        playerAmount = PlayerAmount;
    }
}

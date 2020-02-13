package LOGIC;

public class Options {

    public static float volume;
    public static MoneySpecifier moneySpecifier;
    public static Occurency occurency;
    public static int playerAmount;
    public static boolean mode3D = false;

    public Options(){
        volume = 100;
        occurency = Occurency.$;
        moneySpecifier = MoneySpecifier.Mio;
        playerAmount = 2;
    }

    public void setVolume(float Volume) {
        volume = Volume;
    }

    public void setMoneySize(MoneySpecifier m) {
        moneySpecifier = m;
    }

    public void setPlayerAmount(int PlayerAmount) {
        playerAmount = PlayerAmount;
    }
}


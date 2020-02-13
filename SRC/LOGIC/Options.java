package LOGIC;

import java.io.*;

public class Options {

    public static float volume;
    public static MoneySpecifier moneySpecifier;
    public static Occurency occurency;
    public static int playerAmount;
    public static boolean mode3D = false;

    public Options(){
        if (!loadOptions()) {
            volume = 100;
            occurency = Occurency.$;
            moneySpecifier = MoneySpecifier.Mio;
            playerAmount = 2;
            saveOptions();
        }
    }

    public static void saveOptions(){
        PrintWriter pWriter = null;

        try {
            pWriter = new PrintWriter((new BufferedWriter((new FileWriter("./settings.txt")))));
            pWriter.write("Music Volume:\n" + volume + "\n");
            pWriter.write("Occurency:\n" + occurency + "\n");
            pWriter.write("Specifier:\n" + moneySpecifier);

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
        }
    }

    public boolean loadOptions(){
        BufferedReader in = null;
        File file = new File("./settings.txt");
        if (!file.exists() || !file.canRead()) {
            return false;
        }
        try{
            in = new BufferedReader(new FileReader(file));

            in.readLine();
            float loadedValue = Float.parseFloat(in.readLine());
            if (loadedValue>0 || loadedValue<=100) volume = loadedValue;
            else return false;

            in.readLine();
            String loadedValueS = in.readLine();
            switch (loadedValueS){
                case "$": occurency = Occurency.$; break;
                case "€": occurency = Occurency.€; break;
                case "¥": occurency = Occurency.¥; break;
                case "Ƀ": occurency = Occurency.Ƀ; break;
                default: return false;
            }

            in.readLine();
            loadedValueS = in.readLine();
            switch (loadedValueS){
                case "K": moneySpecifier = MoneySpecifier.K; break;
                case "Mio": moneySpecifier = MoneySpecifier.Mio; break;
                case "Mrd": moneySpecifier = MoneySpecifier.Mrd; break;
                default: return false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}


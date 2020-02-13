package CITY;

import LOGIC.Options;
import LOGIC.Player;

public class Field {

    protected String name = null;
    protected int prize;

    public String getName(){
        return name;
    }

    public String getPrize() { return prize +""+ Options.moneySpecifier + Options.occurency; }

    //execute the spezific action an the player who moved, e.g. buy a street
    public void action(Player player){

    }
}

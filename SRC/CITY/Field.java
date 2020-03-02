package CITY;

import LOGIC.Options;
import LOGIC.Player;

import java.util.ArrayList;

public class Field {

    protected String name = null;
    protected int prize;
    protected int playerAmount;
    ArrayList<Player> curPlayers = new ArrayList();

    // return the name of the field
    public String getName(){
        return name;
    }

    // get the prize of this field
    public String getPrize() { return prize +""+ Options.moneySpecifier + Options.occurency; }

    // add a player to the field an calculate the position of all of them
    public void addPlayers(Player p){



    }

    // delete a player from the field and calculate the position of the remaining ones
    public void deletePlayer(Player p){



    }

    // execute the spezific action an the player who moved, e.g. buy a street
    public void action(Player player){

    }
}

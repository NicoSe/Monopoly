package CITY;


import LOGIC.Player;

import java.awt.*;

public interface Streets {
    Color getColor();
    void changeOwner(Player player);
    Player getOwner();
    void changeHypothekStatus();
    int getHypothek();
    boolean isHypothek();
    boolean buyStreet(Player player);
    boolean payTax(Player player);
    void action(Player player);

}
